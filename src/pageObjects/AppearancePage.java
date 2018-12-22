package pageObjects;

import optimize.Optimizer;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class AppearancePage {
    private Optimizer optimizer;
    private WebDriver driver;
    private ReadPropertyFile propertyFile;

    @FindBy(xpath = "//*[@id=\"pt-notifications-alert\"]")
    private WebElement alert;

    @FindBy(xpath = "/html/body/div[8]/div[4]/div[1]/div[3]/div/span/span[2]/a")
    private WebElement preferences;

    @FindBy(className = "oo-ui-labelElement-label")
    private WebElement appearance;

    @FindBy(id = "ooui-php-49")
    private WebElement MinervaNeue;

    public AppearancePage(WebDriver driver) throws IOException{
        this.driver = driver;
    }

    public void logIn() throws IOException {
        optimizer.loginToWiki(driver, propertyFile);
    }

    public void getToAppearance(){
        alert.click();
        preferences.click();
        appearance.click();
    }

    public void interfaceSkinChange(){
        MinervaNeue.click();
        Assert.assertEquals("minerva", MinervaNeue.getAttribute("value"));
    }

    public void closeDriver(){
        driver.quit();
    }
}
