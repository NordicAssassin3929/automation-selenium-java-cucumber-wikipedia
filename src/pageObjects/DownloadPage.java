package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class DownloadPage {
    private ReadPropertyFile propertyFile;
    private WebDriver driver;

    @FindBy(id = "coll-download-as-rdf2latex")
    private WebElement downloadAsPdf;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div[3]/form/div/span/span/button")
    private WebElement downloadButton;

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

    public DownloadPage(WebDriver driver) throws IOException{
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

    public void DownloadAsPdf(){
        downloadAsPdf.click();
    }

    public void DownloadButton(){
        downloadButton.click();
        Assert.assertTrue("Nothing could be downloaded", ExpectedConditions.alertIsPresent() != null);
    }

    public void closeDriver(){
        driver.quit();
    }
}
