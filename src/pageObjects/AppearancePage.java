package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class AppearancePage {
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

    public AppearancePage(WebDriver driver) throws IOException{
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
