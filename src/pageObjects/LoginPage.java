package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class LoginPage {
    private WebDriver driver;
    private ReadPropertyFile propertyFile;

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

    /*
    1. Gherkin fileovi su malo šturi i nekad ne jasni, npr. "Givem Log In"
    3. Također, u Gherkinu se mijenja lice - nekad "Ja" a nekad "korisnik"
    4. Iz 1. klase poziva metodu iz 2. klase koja poziva metodu iz 3. klase, a jednostavno je mogao iz 1. pozvati metodu koja je u 3. klasi direktno
    5. Elementi se dohvaćaju na način koji je malo drugačiji od standtardnog sa fixtureom, npr.
    @ FindBy ( >span class="ID0EZKBG">= " wpLoginAttempt " )
     */
    public LoginPage(WebDriver driver) throws IOException{
        this.driver = driver;
    }

    // allocates to the log in button from homepage
    public void allocateToLogIn(){
        englishArticles.click();
        LogInButton.click();
    }

    public void enterCredentials() throws IOException {
        propertyFile = new ReadPropertyFile();
        //optimizer.sendKeysAndAssert(driver, usernameElement, propertyFile.getUsername(), "Wrong username");
        //optimizer.sendKeysAndAssert(driver, passwordElement, propertyFile.getPassword(), "Wrong password");
    }

    public void clickLogIn(){
        login.click();
    }

    public void closeDriver(){
        driver.quit();
    }
}
