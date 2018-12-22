package testcases;

import BrowserFactory.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SearchPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyWikiSearch {
    private SearchPage searchPage;
    ReadPropertyFile propertyFile;
    BrowserFactory browserFactory;

    @Before("@Test_2")
    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        String url = propertyFile.getUrl();
        String browser = propertyFile.getBrowser();
        WebDriver driver = browserFactory.startBrowser(browser, url);
        searchPage = PageFactory.initElements(driver, SearchPage.class);
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
