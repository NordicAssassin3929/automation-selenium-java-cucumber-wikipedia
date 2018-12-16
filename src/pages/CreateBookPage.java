package pages;

import optimize.Optimizer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class CreateBookPage{
    private Optimizer optimizer;
    private ReadPropertyFile propertyFile;
    private WebDriver driver;
    private By createBook = By.id("coll-create_a_book");
    private By bookCreator = By.xpath("/html/body/div[3]/div[3]/div[3]/form/span/span[1]/button");
    private By search = By.name("search");
    private By addPageToBook = By.xpath("//*[@id=\"coll-add_article\"]");
    private By showBook = By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/a[2]");
    private By bookTitle = By.id("titleInput");
    private By bookSubtitle = By.id("subtitleInput");
    private By createChapter = By.xpath("/html/body/div[3]/div[3]/div[3]/div[3]/div[1]/div[1]/a[1]");

    // login
    private By englishArticles = By.id("js-link-box-en");
    private By LogInButton = By.id("pt-login");
    private By usernameElement = By.name("wpName");
    private By passwordElement = By.name("wpPassword");
    private By login = By.id("wpLoginAttempt");

    public CreateBookPage(WebDriver driver)throws IOException{
        this.driver = driver;
        optimizer = new Optimizer();
        setup();
    }

    public void setup() throws IOException {
        propertyFile = new ReadPropertyFile();
        System.out.println("Test started");
        System.setProperty(propertyFile.getPropertiesKey(), propertyFile.getPropertiesValue());
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(propertyFile.getUrl());
    }

    public void logIn() throws IOException {
        propertyFile = new ReadPropertyFile();
        driver.findElement(englishArticles).click();
        driver.findElement(LogInButton).click();
        optimizer.sendKeysAndAssert(driver, usernameElement, propertyFile.getUsername(), "Wrong username");
        optimizer.sendKeysAndAssert(driver, passwordElement, propertyFile.getPassword(), "Wrong password");
        driver.findElement(login).click();
    }

    public void createBook(){
        driver.findElement(createBook).click();
        driver.findElement(bookCreator).click();
    }

    public void searchAddShow(){
        driver.findElement(search).sendKeys(propertyFile.getBookSearchWord());
        driver.findElement(addPageToBook).click();
        driver.findElement(showBook).click();
    }

    public void setChapterDetails(){
        driver.findElement(bookTitle).sendKeys(propertyFile.getBookTitle());
        driver.findElement(bookSubtitle).sendKeys(propertyFile.getBookSubtitle());
        driver.findElement(createChapter).click();
        driver.switchTo().alert().sendKeys(propertyFile.getBookChapter());
        driver.switchTo().alert().accept();
        Assert.assertTrue("Chapter not added", ExpectedConditions.alertIsPresent() != null);
    }

    public void closeDriver(){
        driver.quit();
    }
}
