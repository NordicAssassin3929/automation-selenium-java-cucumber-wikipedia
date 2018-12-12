package testcases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DownloadPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyPdfDownload {
    WebDriver driver;
    DownloadPage downloadPage;
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

    @Given("^Open firefox before coming to download$")
    public void Open_firefox() throws Throwable {
        setup();
        downloadPage = new DownloadPage(driver);
        downloadPage.logIn();
    }

    @Given("^Gets to download button$")
    public void Gets_to_download_button() throws Throwable {
        downloadPage.DownloadAsPdf();
    }

    @When("^User clicks on download button$")
    public void User_clicks_on_download_button() throws Throwable {
        downloadPage.DownloadButton();
    }

    @Then("^pdf can be downloaded$")
    public void pdf_can_be_downloaded() throws Throwable {
        System.out.println("Success");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        downloadPage.closeDriver();
    }
}
