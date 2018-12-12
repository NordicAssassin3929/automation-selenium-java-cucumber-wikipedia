package pages;

import optimize.Optimizer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class CreateBookPage{
    Optimizer optimizer;
    ReadPropertyFile propertyFile;
    WebDriver driver;
    By createBook = By.id("coll-create_a_book");
    By bookCreator = By.xpath("/html/body/div[3]/div[3]/div[3]/form/span/span[1]/button");
    By search = By.name("search");
    By addPageToBook = By.xpath("//*[@id=\"coll-add_article\"]");
    By showBook = By.xpath("/html/body/div[3]/div[1]/div[2]/div[2]/div/div[2]/a[2]");
    By bookTitle = By.id("titleInput");
    By bookSubtitle = By.id("subtitleInput");
    By createChapter = By.xpath("/html/body/div[3]/div[3]/div[3]/div[3]/div[1]/div[1]/a[1]");

    // login
    By englishArticles = By.id("js-link-box-en");
    By LogInButton = By.id("pt-login");
    By usernameElement = By.name("wpName");
    By passwordElement = By.name("wpPassword");
    By login = By.id("wpLoginAttempt");

    public CreateBookPage(WebDriver driver){
        this.driver = driver;
        optimizer = new Optimizer();
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
        driver.close();
    }
}