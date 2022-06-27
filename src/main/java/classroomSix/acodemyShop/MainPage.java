package classroomSix.acodemyShop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

private By searchinputField = By.id("woocommerce-product-search-field-0");
    private By searchResults = By.className("product");
    public WebElement getSearchInputField(){
        return driver.findElement(searchinputField);
    }

    public List<WebElement> getSSearchResults(){
        return (List<WebElement>) driver.findElement(searchResults);
    }

    public void searchProduct(String searchParam){
        getSearchInputField().clear();
        getSearchInputField().sendKeys("searchParam");
        new Actions(driver).sendKeys(Keys.ENTER).perform();

    }
}
