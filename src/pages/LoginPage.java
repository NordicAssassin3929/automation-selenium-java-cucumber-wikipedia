package pages;

import optimize.Optimizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import propertyFileReader.ReadPropertyFile;
import setup.Setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    Setup setup;
    Optimizer optimizer;
    WebDriver driver;
    ReadPropertyFile propertyFile;
    By englishArticles = By.id("js-link-box-en");
    By LogInButton = By.id("pt-login");
    By usernameElement = By.name("wpName");
    By passwordElement = By.name("wpPassword");
    By login = By.id("wpLoginAttempt");

    public LoginPage(WebDriver driver) throws IOException{
        this.driver = driver;
        optimizer = new Optimizer();
        //setup = new Setup(driver);
        setup();
    }

    public void setup() throws IOException{
        propertyFile = new ReadPropertyFile();
        System.out.println("Test started");
        System.setProperty(propertyFile.getPropertiesKey(), propertyFile.getPropertiesValue());
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(propertyFile.getUrl());
    }

    // allocates to the log in button from homepage
    public void allocateToLogIn(){
        driver.findElement(englishArticles).click();
        driver.findElement(LogInButton).click();
    }

    public void enterCredentials() throws IOException {
        propertyFile = new ReadPropertyFile();
        optimizer.sendKeysAndAssert(driver, usernameElement, propertyFile.getUsername(), "Wrong username");
        optimizer.sendKeysAndAssert(driver, passwordElement, propertyFile.getPassword(), "Wrong password");
    }

    public void clickLogIn(){
        driver.findElement(login).click();
    }

    public void closeDriver(){
        driver.quit();
    }
}
