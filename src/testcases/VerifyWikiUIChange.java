package testcases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PreferencesPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VerifyWikiUIChange {
    WebDriver driver;
    PreferencesPage page;
    ReadPropertyFile propertyFile;

    @BeforeMethod
    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        System.out.println("Test started");
        System.setProperty(propertyFile.getPropertiesKey(), propertyFile.getPropertiesValue());
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(propertyFile.getUrl());
    }

    @Given("^Open firefox before changing visual appearance$")
    public void Open_firefox() throws Throwable {
        setup();
        page = new PreferencesPage(driver);
    }

    @Given("^Log in as user$")
    public void Log_in_as_user() throws Throwable {
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        page.closeDriver();
    }
}
