package testcases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyWikiLogin {
    ReadPropertyFile propertyFile;
    LoginPage loginPage;
    WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        System.out.println("Test started");
        System.setProperty(propertyFile.getPropertiesKey(), propertyFile.getPropertiesValue());
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(propertyFile.getUrl());
    }

    @Given("^Open firefox, and locate to log in page$")
    public void Open_firefox_locate_to_log_in_page() throws Throwable {
        setup();
        loginPage = new LoginPage(driver);
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

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        loginPage.closeDriver();
    }
}
