package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class SearchPage{
    private ReadPropertyFile propertyFile;
    private WebDriver driver;

    @FindBy(name = "search")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public SearchPage(WebDriver driver) throws IOException {
        this.driver = driver;
        propertyFile = new ReadPropertyFile();
    }

    public void enterSearch(){
        searchBar.sendKeys(propertyFile.getSearchInput());
    }

    public void clickSearch(){
        searchButton.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Porsche"));
    }

    public void closeDriver(){
        driver.quit();
    }
}
