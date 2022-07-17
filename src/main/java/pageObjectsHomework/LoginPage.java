package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public static WebDriver driver;
    private static By usernameInputField = By.id("user-name");
    private static By passwordInputField = By.id("password");
    private static By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public static WebElement getUsernameInputField(){
        return driver.findElement(usernameInputField);

    }
    public static WebElement getPasswordInputField(){
        return driver.findElement(passwordInputField);

    }

    public static WebElement getLoginButton(){
        return driver.findElement(loginButton);

    }

}
