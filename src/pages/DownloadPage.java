package pages;

import optimize.Optimizer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class DownloadPage {
    Optimizer optimizer;
    ReadPropertyFile propertyFile;
    WebDriver driver;
    By downloadAsPdf = By.id("coll-download-as-rdf2latex");
    By downloadButton = By.xpath("/html/body/div[3]/div[3]/div[3]/form/div/span/span/button");

    public DownloadPage(WebDriver driver) throws IOException{
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
        optimizer.loginToWiki(driver, propertyFile);
    }

    public void DownloadAsPdf(){
        driver.findElement(downloadAsPdf).click();
    }

    public void DownloadButton(){
        driver.findElement(downloadButton).click();
        Assert.assertTrue("Nothing could be downloaded", ExpectedConditions.alertIsPresent() != null);
    }

    public void closeDriver(){
        driver.quit();
    }
}
