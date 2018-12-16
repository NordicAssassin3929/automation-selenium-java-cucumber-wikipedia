package testcases;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import java.io.IOException;

public class VerifyWikiLogin {
    private LoginPage loginPage;
    private WebDriver driver;

    @Before("@Test_1")
    public void setup() throws IOException {
        loginPage = new LoginPage(driver);
    }

    @Given("^Allocate to log in page$")
    public void allocate_to_log_in_page() throws Throwable {
        loginPage.allocateToLogIn();
    }

    @When("^Entering credentials$")
    public void entering_credentials() throws Throwable {
        loginPage.enterCredentials();
    }

    @Then("^User should be able to log in successfully$")
    public void log_in_complete() throws Throwable {
        loginPage.clickLogIn();
    }

    @After("@Test_1")
    public void tearDown(){
        loginPage.closeDriver();
    }
}
