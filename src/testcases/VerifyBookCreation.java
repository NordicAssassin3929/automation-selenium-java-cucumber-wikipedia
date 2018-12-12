package testcases;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CreateBookPage;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class VerifyBookCreation{
    WebDriver driver;
    CreateBookPage createBookPage;
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

    @Given("^Open firefox, and login$")
    public void Open_firefox_and_login() throws Throwable {
        setup();
        createBookPage = new CreateBookPage(driver);
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

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        createBookPage.closeDriver();
    }
}
