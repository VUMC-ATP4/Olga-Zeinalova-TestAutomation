package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {

    WebDriver safariBrowseris;

    @BeforeMethod
    public void openBrowser(){
        safariBrowseris = new SafariDriver();

    }

    @Test
    public void firstTest(){
        String url = "https://www.apple.com";
        safariBrowseris.get(url);
        String expectedTitle = "Apple";
        String actualTitle = safariBrowseris.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }

    @Test
    public void secondTest() {
        String url = "https://www.delfi.lv";
        safariBrowseris.get(url);
        String expectedTitle = "DELFI - Vadošais ziņu portāls Latvijā - DELFI";
        String actualTitle = safariBrowseris.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

    }


    @AfterMethod
    public void  closeBrowser(){
        safariBrowseris.quit();
    }



}
