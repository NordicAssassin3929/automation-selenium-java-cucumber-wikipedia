package testcases;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import java.io.IOException;

public class VerifyWikiSearch {
    private SearchPage searchPage;
    private WebDriver driver;

    @Before("@Test_2")
    public void setup() throws IOException {
        searchPage = new SearchPage(driver);
    }

    @Given("^I enter term in search$")
    public void entering_seacrch_term() throws Throwable {
        searchPage.enterSearch();
    }

    @Then("^User should get the page with term searched$")
    public void get_search_input() throws Throwable {
        searchPage.clickSearch();
    }

    @After("@Test_2")
    public void tearDown(){
        searchPage.closeDriver();
    }
}
