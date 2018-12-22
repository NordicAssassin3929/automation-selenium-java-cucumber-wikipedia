package testcases;

import BrowserFactory.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

/*
    1. Gherkin fileovi su malo šturi i nekad ne jasni, npr. "Givem Log In"
    3. Također, u Gherkinu se mijenja lice - nekad "Ja" a nekad "korisnik"
    4. Iz 1. klase poziva metodu iz 2. klase koja poziva metodu iz 3. klase, a jednostavno je mogao iz 1. pozvati metodu koja je u 3. klasi direktno
    5. Elementi se dohvaćaju na način koji je malo drugačiji od standtardnog sa fixtureom, npr.
    @ FindBy ( >span class="ID0EZKBG">= " wpLoginAttempt " )
     */
public class VerifyWikiLogin {
    private LoginPage loginPage;
    BrowserFactory browserFactory;
    ReadPropertyFile propertyFile;

    @Before("@Test_1")
    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        String url = propertyFile.getUrl();
        String browser = propertyFile.getBrowser();
        WebDriver driver = browserFactory.startBrowser(browser, url);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
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
