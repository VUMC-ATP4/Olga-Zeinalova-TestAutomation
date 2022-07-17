package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    public static WebDriver driver;
    private static By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private static By pageTitleText = By.cssSelector("div[id='header_container'] span[class='title']");
    private static By selectShoppingCart = By.cssSelector("div[id='shopping_cart_container'] a[class='shopping_cart_link']");


    public InventoryPage (WebDriver driver) {
        this.driver = driver;

    }
    public WebElement getToCartButton(){
        return  driver.findElement(addToCartButton);

    }

    public WebElement getPageTitle() {
        return driver.findElement(pageTitleText);
    }


    public WebElement getSelectShoppingCart() {
        return driver.findElement(selectShoppingCart);
    }
}
