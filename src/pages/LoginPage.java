package pages;

import optimize.Optimizer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class LoginPage {
    Optimizer optimizer;
    WebDriver driver;
    ReadPropertyFile propertyFile;
    By englishArticles = By.id("js-link-box-en");
    By LogInButton = By.id("pt-login");
    By usernameElement = By.name("wpName");
    By passwordElement = By.name("wpPassword");
    By login = By.id("wpLoginAttempt");

    public LoginPage(WebDriver driver){
        this.driver = driver;
        optimizer = new Optimizer();
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
        driver.close();
    }
}
