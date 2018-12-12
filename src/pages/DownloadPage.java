package pages;

import optimize.Optimizer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class DownloadPage {
    Optimizer optimizer;
    ReadPropertyFile propertyFile;
    WebDriver driver;
    By downloadAsPdf = By.id("coll-download-as-rdf2latex");
    By downloadButton = By.xpath("/html/body/div[3]/div[3]/div[3]/form/div/span/span/button");

    public DownloadPage(WebDriver driver){
        this.driver = driver;
        optimizer = new Optimizer();
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
        driver.close();
    }
}
