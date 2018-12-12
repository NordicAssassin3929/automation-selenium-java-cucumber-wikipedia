package optimize;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;


public class Optimizer {

    // login
    By englishArticles = By.id("js-link-box-en");
    By LogInButton = By.id("pt-login");
    By usernameElement = By.name("wpName");
    By passwordElement = By.name("wpPassword");
    By login = By.id("wpLoginAttempt");

    public void sendKeysAndAssert(WebDriver driver, By element, String propertyValue, String message){
        driver.findElement(element).sendKeys(propertyValue);
        Assert.assertEquals(message, propertyValue, driver.findElement(element).getAttribute("value"));
    }

    public void loginToWiki(WebDriver driver, ReadPropertyFile propertyFile) throws IOException {
        propertyFile = new ReadPropertyFile();
        driver.findElement(englishArticles).click();
        driver.findElement(LogInButton).click();
        sendKeysAndAssert(driver, usernameElement, propertyFile.getUsername(), "Wrong username");
        sendKeysAndAssert(driver, passwordElement, propertyFile.getPassword(), "Wrong password");
        driver.findElement(login).click();
    }
}
