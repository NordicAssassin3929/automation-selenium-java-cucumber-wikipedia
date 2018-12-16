package pages;

import optimize.Optimizer;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class PreferencesPage {
    private Optimizer optimizer;
    private WebDriver driver;
    private ReadPropertyFile propertyFile;
    private By alert = By.xpath("//*[@id=\"pt-notifications-alert\"]");
    private By preferences = By.xpath("/html/body/div[8]/div[4]/div[1]/div[3]/div/span/span[2]/a");
    private By appearance = By.className("oo-ui-labelElement-label");
    private By MinervaNeue = By.id("ooui-php-49");

    public PreferencesPage(WebDriver driver) throws IOException{
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
        driver.quit();
    }
}
