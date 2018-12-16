package testcases;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PreferencesPage;
import java.io.IOException;

public class VerifyWikiUIChange {
    private WebDriver driver;
    private PreferencesPage page;

    @Before("@Test_3")
    public void setup() throws IOException {
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
    }

    @After("@Test_3")
    public void tearDown(){
        page.closeDriver();
    }
}
