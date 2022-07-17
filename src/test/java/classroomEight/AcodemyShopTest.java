package classroomEight;

import classroomSix.acodemyShop.MainPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;

    public final String ACODEMY_SHOP_URL = "http://shop.acodemy.lv";
// komentars

    @BeforeMethod
    public void setupBrowser() {
        System.out.println("Pirms testa");
        driver = new SafariDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void searchForItemTest() {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        System.out.println("Search results count:" + mainPage.getSSearchResults().size());
        Assert.assertEquals(mainPage.getSSearchResults().size(), 2);
    }


    @Test
    public void searchForItemTestTwo() {
        driver.get(ACODEMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Hoodie");
        System.out.println("Search results count:" + mainPage.getSSearchResults().size());
        Assert.assertEquals(mainPage.getSSearchResults().size(), 3);
    }

    @Test
    public void switchTabsTest() {
        driver.get("https://www.w3schools.com/");
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        driver.findElement(By.id("accept-choices")).click();
        driver.findElement(By.cssSelector("a[title='W3Schools on LinkedIn']")).click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        System.out.println();
    }


    @Test
    public void javaScriptExecutorExampleTest() throws InterruptedException {
        driver.get("https://www.lu.lv/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[id='ccm__footer__consent-bar-submit']")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
        driver.findElement(By.className("footer__up")).click();

        WebElement element = driver.findElement(By.linkText("Kontakti"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);
        WebElement menu = driver.findElement(By.className("menuContainer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", menu);
        Thread.sleep(2000);

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    @Test
    public void hoverTest(){
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        WebElement hoverMeButton = driver.findElement(By.cssSelector("div.dropdown2 button"));
        driver.findElement(By.linkText("Link 1")).click();

    }

    @Test
    public void seleniumDocTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/");
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();
        Thread.sleep(5000);

    }


    @Test
    public void keyboardClickTest() throws InterruptedException {
        driver.get("https://www.microsoft.com/applied-sciences/projects/anti-ghosting-demo");
        driver.findElement(By.id("clickToUseButton")).click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.ALT)
                .perform();

        Thread.sleep(5000);

        new Actions(driver)
                .keyUp(Keys.ALT)
                .perform();

        Thread.sleep(5000);

        new Actions(driver)
                .sendKeys("J")
                .sendKeys("U")
                .sendKeys("R")
                .sendKeys("I")
                .sendKeys("S")
                .perform();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("Pēc testa");
        driver.quit();
    }
}
