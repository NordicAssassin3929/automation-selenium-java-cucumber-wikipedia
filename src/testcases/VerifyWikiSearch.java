package testcases;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

import java.io.IOException;

public class VerifyWikiSearch {
    SearchPage searchPage;
    WebDriver driver;

    @Before("@Test_2")
    public void setup() throws IOException {
        searchPage = new SearchPage(driver);
    }

    @Given("^I enter term in search$")
    public void I_enter_term_in_search() throws Throwable {
        searchPage.enterSearch();
    }

    @Then("^User should get the page with term searched$")
    public void User_should_get_the_webpage_with_term_searched() throws Throwable {
        searchPage.clickSearch();
    }

    @After("@Test_2")
    public void tearDown(){
        searchPage.closeDriver();
    }
}
