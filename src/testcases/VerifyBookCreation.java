package testcases;

import BrowserFactory.BrowserFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CreateBookPage;
import pageObjects.DownloadPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyBookCreation{
    private WebDriver driver;
    private CreateBookPage createBookPage;
    private BrowserFactory browserFactory;
    private ReadPropertyFile propertyFile;

    @Before("@Test_5")
    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        String url = propertyFile.getUrl();
        String browser = propertyFile.getBrowser();
        WebDriver driver = browserFactory.startBrowser(browser, url);
        createBookPage = PageFactory.initElements(driver, CreateBookPage.class);
    }

    @Given("^Log in wiki$")
    public void login() throws Throwable {
        createBookPage.logIn();
    }

    @Given("^Create a book and start book creator$")
    public void Create_a_book_and_start_book_creator() throws Throwable {
        createBookPage.createBook();
    }

    @Given("^Search for keyword, add to book and show book$")
    public void Search_for_keyword_add_to_book_and_show_book() throws Throwable {
        createBookPage.searchAddShow();
    }

    @When("^Set title, subtitle, click create chapter and set  chapter name$")
    public void Set_title_subtitle_click_create_chapter_and_set_chapter_name() throws Throwable {
        createBookPage.setChapterDetails();
    }

    @Then("^Chapter is created successfully$")
    public void Chapter_is_created_successfully() throws Throwable {
    }

    @After("@Test_5")
    public void tearDown(){
        createBookPage.closeDriver();
    }
}
