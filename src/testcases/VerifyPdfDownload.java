package testcases;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DownloadPage;

import java.io.IOException;

public class VerifyPdfDownload {
    private WebDriver driver;
    private DownloadPage downloadPage;

    @Before("@Test_4")
    public void setup() throws IOException {
        downloadPage = new DownloadPage(driver);
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
