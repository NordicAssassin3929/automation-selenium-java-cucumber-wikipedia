package testcases;

import BrowserFactory.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import optimize.Optimizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AppearancePage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyWikiAppearanceChange {
    private AppearancePage page;
    ReadPropertyFile propertyFile;
    BrowserFactory browserFactory;
    WebDriver driver;

    @Before("@Test_3")
    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        String url = propertyFile.getUrl();
        String browser = propertyFile.getBrowser();
        driver = browserFactory.startBrowser(browser, url);
        page = PageFactory.initElements(driver, AppearancePage.class);
    }

    @Given("^Log in as user$")
    public void Log_in_as_user() throws Throwable {
        //optimizer.loginToWiki(driver, propertyFile);
        page.logIn();
    }

    @Given("^Get to appearance$")
    public void Get_to_appearance() throws Throwable {
        page.getToAppearance();
    }

    @When("^User clicks on new skin$")
    public void User_clicks_on_new_skin() throws Throwable {
        page.interfaceSkinChange();
    }

    @Then("^User should see UI changes$")
    public void User_should_see_UI_changes() throws Throwable {
    }

    @After("@Test_3")
    public void tearDown(){
        page.closeDriver();
    }
}
