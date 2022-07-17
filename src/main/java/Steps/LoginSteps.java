package Steps;

import classroomSix.acodemyShop.InventoryPage;
import classroomSix.pageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    InventoryPage inventoryPage;

    public final String SAUCELABS_URL = "https://www.saucedemo.com";

    @Before
    public void setUp(){
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);


    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("User is navigated to saucelabs page")
    public void user_is_navigated_to_saucelabs_page() {
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(SAUCELABS_URL);
        Assert.assertEquals(driver.getTitle(), "Swag Labs");

    }

    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        System.out.println("user enters "+username+" and "+password+"");
    }

    @When("user enters{string} and {string}")
    public void user_enters_and(String username) {

    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        System.out.println("user clicks login button");
    }
    @Then("user sees inventory page")
    public void user_sees_inventory_page() {
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "Products");

    }

    @Then("user sees page title {string}")
    public void userSeesPageTitlePage_title() {
    }

    @Then("user sees error message {string}")
    public void userSeesErrorMessageErrormessage(String errormessage) {
        Assert.assertEquals(loginPage.getErrorText(), errormessage);
    }
}

