package optimize;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class Optimizer {

    // login
    @FindBy(id = "js-link-box-en")
    private static WebElement englishArticles;

    @FindBy(id = "pt-login")
    private static WebElement LogInButton;

    @FindBy(name = "wpName")
    private static WebElement usernameElement;

    @FindBy(name = "wpPassword")
    private static WebElement passwordElement;

    @FindBy(id = "wpLoginAttempt")
    private static WebElement login;

    public static void sendKeysAndAssert(WebDriver driver, WebElement element, String propertyValue, String message){
        element.sendKeys(propertyValue);
        Assert.assertEquals(message, propertyValue, element.getAttribute("value"));
    }

    public static void loginToWiki(WebDriver driver, ReadPropertyFile propertyFile) throws IOException {
        propertyFile = new ReadPropertyFile();
        englishArticles.click();
        LogInButton.click();
        sendKeysAndAssert(driver, usernameElement, propertyFile.getUsername(), "Wrong username");
        sendKeysAndAssert(driver, passwordElement, propertyFile.getPassword(), "Wrong password");
        login.click();
    }
}
