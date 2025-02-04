package testcases;

import BrowserFactory.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.DownloadPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyPdfDownload {
    private WebDriver driver;
    private DownloadPage downloadPage;
    private BrowserFactory browserFactory;
    private ReadPropertyFile propertyFile;

    @Before("@Test_4")
    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        String url = propertyFile.getUrl();
        String browser = propertyFile.getBrowser();
        WebDriver driver = browserFactory.startBrowser(browser, url);
        downloadPage = PageFactory.initElements(driver, DownloadPage.class);
    }

    @Given("^Log in$")
    public void Open_firefox() throws Throwable {
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

    @After("@Test_4")
    public void tearDown(){
        downloadPage.closeDriver();
    }
}
