package classroomSeven;

import classroomSix.acodemyShop.InventoryPage;
import classroomSix.pageObjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    WebDriver driver;
    WebDriverWait wait;
    public final String SAUCELABS_URL = "https://www.saucedemo.com";


    @BeforeMethod
    public void setupBrowser() {
        System.out.println("PIRMS TESTA");
        driver = new SafariDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @Test
    public void errorMessagePasswordEmptyTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELABS_URL);
        WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
        System.out.println(acceptedUsernamesText.getText());
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("Olga");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals(errorText.getText(),"Epic sadface: Password is required");
        Thread.sleep(5000);
        driver.close();
        //otrs variants
        // String actualText = errorText.getText();
        // String expectedText = "Epic sadface: Password is required";
        //Assert.assertEquals(errorText.getText();
    }
    @Test
    public void errorMessagePasswordEmptyPageObjectTest(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Olga", "");
        Assert.assertEquals(loginPage.getErrorText().getText(), "Epic sadface: Password is required");


    }

    @Test
    public void successLoginPageObject(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "Products");


    }


    @Test
    public void errorMessageUsernameEmptyTest() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        System.out.println("TESTS");
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("qwerty 123");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals(errorText.getText(), "Epic sadface: Username is required");
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        WebElement acceptUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
        System.out.println(acceptUsernamesText.getText());
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();
      //  Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(pageTitleText.getText(),"Products");
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByValue("hilo");
        Thread.sleep(5000);
        sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByIndex(1);

     //   WebElement linkedInLink = driver.findElement(By.linkText("Linkedin"));
      //  linkedInLink.click();

        Thread.sleep(5000);
        driver.close();
    }

   @Test
   public void localHTMLExerciseTest() throws InterruptedException{
      driver.get("file:///Users/olgasab/Desktop/JAVA ATP4/MyFirstAutomationProjet/src/test/resources/elements.html");
        WebElement descriptionTextArea = driver.findElement(By.name("description"));
        descriptionTextArea.sendKeys("šis ir teksts par mani");
        WebElement isStudentCheckbox = driver.findElement(By.id("studentID"));
       Assert.assertEquals(isStudentCheckbox.isSelected(),false);
       isStudentCheckbox.click();
       Assert.assertEquals(isStudentCheckbox.isSelected(),true);
       Select milakaKrasa = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasa.selectByIndex(0);
        milakaKrasa.selectByIndex(3);

   List<WebElement> sarakstsArKrasam = milakaKrasa.getOptions();
    for(int i = 0; i < sarakstsArKrasam.size(); i++) {
       System.out.println(sarakstsArKrasam.get(i).getText());
    }

    WebElement nospiedManiPoga = driver.findElement(By.id("checkDataResultID"));
    nospiedManiPoga.click();
    WebElement vissIrLabiTeksts = driver.findElement(By.id("checkDataResultID"));
   // wait.until(ExpectedCondition.elementToBeClickable(vissIrLabiTeksts));

    vissIrLabiTeksts.click();




  }


    @Test
    public void myTest2() {
        driver.get(SAUCELABS_URL);
        System.out.println("TESTS");
        driver.close();
    }

    @AfterMethod
    public void tearDownBrowser() {
        System.out.println("PĒC TESTA");

    }


}