package testcases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SearchPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyWikiSearch {
    ReadPropertyFile propertyFile;
    SearchPage searchPage;
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

    @Given("^Open firefox before searching functionality$")
    public void Open_firefox() throws Throwable {
        setup();
        searchPage = new SearchPage(driver);
    }

    @When("^I enter term in search$")
    public void I_enter_term_in_search() throws Throwable {
        searchPage.enterSearch(propertyFile.getSearchInput());
    }

    @Then("^User should get the page with term searched$")
    public void User_should_get_the_webpage_with_term_searched() throws Throwable {
        searchPage.clickSearch();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        searchPage.closeDriver();
    }
}
