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
    LoginPage loginPage;
    WebDriver driver;

    @Before("@Test_1")
    public void setup() throws IOException {
        loginPage = new LoginPage(driver);
    }

    @Given("^Open firefox, and locate to log in page$")
    public void Open_firefox_locate_to_log_in_page() throws Throwable {
        loginPage.allocateToLogIn();
    }

    @When("^I enter valid username and valid password$")
    public void I_enter_valid_username_and_valid_password() throws Throwable {
        loginPage.enterCredentials();
    }

    @Then("^User should be able to log in successfully$")
    public void User_should_be_able_to_log_in_successfully() throws Throwable {
        loginPage.clickLogIn();
    }

    @After("@Test_1")
    public void tearDown(){
        loginPage.closeDriver();
    }
}
