package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class CreateBookPage{
    private ReadPropertyFile propertyFile;
    private WebDriver driver;

    @FindBy(id = "coll-create_a_book")
    private WebElement createBook;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div[3]/form/span/span[1]/button")
    private WebElement bookCreator;

    @FindBy(name = "search")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"coll-add_article\"]")
    private WebElement addPageToBook;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/a[2]")
    private WebElement showBook;

    @FindBy(id = "titleInput")
    private WebElement bookTitle;

    @FindBy(id = "subtitleInput")
    private WebElement bookSubtitle;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div[3]/div[3]/div[1]/div[1]/a[1]")
    private WebElement createChapter;

    // login
    @FindBy(id = "js-link-box-en")
    private WebElement englishArticles;

    @FindBy(id = "pt-login")
    private WebElement LogInButton;

    @FindBy(name = "wpName")
    private WebElement usernameElement;

    @FindBy(name = "wpPassword")
    private WebElement passwordElement;

    @FindBy(id = "wpLoginAttempt")
    private WebElement login;

    public CreateBookPage(WebDriver driver)throws IOException{
        this.driver = driver;
    }

    public void logIn() throws IOException {
        propertyFile = new ReadPropertyFile();
        englishArticles.click();
        LogInButton.click();
        //sendKeysAndAssert(driver, usernameElement, propertyFile.getUsername(), "Wrong username");
        //sendKeysAndAssert(driver, passwordElement, propertyFile.getPassword(), "Wrong password");
        usernameElement.sendKeys(propertyFile.getUsername());
        passwordElement.sendKeys(propertyFile.getPassword());
        login.click();
    }

    public void createBook(){
        createBook.click();
        bookCreator.click();
    }

    public void searchAddShow(){
        search.sendKeys(propertyFile.getBookSearchWord());
        addPageToBook.click();
        showBook.click();
    }

    public void setChapterDetails(){
        bookTitle.sendKeys(propertyFile.getBookTitle());
        bookSubtitle.sendKeys(propertyFile.getBookSubtitle());
        createChapter.click();
        driver.switchTo().alert().sendKeys(propertyFile.getBookChapter());
        driver.switchTo().alert().accept();
        Assert.assertTrue("Chapter not added", ExpectedConditions.alertIsPresent() != null);
    }

    public void closeDriver(){
        driver.quit();
    }
}
