package pages;

import optimize.Optimizer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class PreferencesPage {
    Optimizer optimizer;
    WebDriver driver;
    ReadPropertyFile propertyFile;
    By alert = By.xpath("//*[@id=\"pt-notifications-alert\"]");
    By preferences = By.xpath("/html/body/div[8]/div[4]/div[1]/div[3]/div/span/span[2]/a");
    By appearance = By.className("oo-ui-labelElement-label");
    By MinervaNeue = By.id("ooui-php-49");

    public PreferencesPage(WebDriver driver){
        this.driver = driver;
        optimizer = new Optimizer();
    }

    public void logIn() throws IOException {
        optimizer.loginToWiki(driver, propertyFile);
    }

    public void getToAppearance(){
        driver.findElement(alert).click();
        driver.findElement(preferences).click();
        driver.findElement(appearance).click();
    }

    public void interfaceSkinChange(){
        driver.findElement(MinervaNeue).click();
        Assert.assertEquals("minerva", driver.findElement(MinervaNeue).getAttribute("value"));
    }

    public void closeDriver(){
        driver.close();
    }
}
