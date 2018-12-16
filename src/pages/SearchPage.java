package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import propertyFileReader.ReadPropertyFile;
import java.io.IOException;

public class SearchPage{
    private ReadPropertyFile propertyFile;
    private WebDriver driver;
    private By searchBar = By.name("search");
    private By searchButton = By.xpath("//button[@type='submit']");

    public SearchPage(WebDriver driver) throws IOException{
        this.driver = driver;
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

    public void enterSearch(){
        driver.findElement(searchBar).sendKeys(propertyFile.getSearchInput());
    }

    public void clickSearch(){
        driver.findElement(searchButton).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Porsche"));
    }

    public void closeDriver(){
        driver.quit();
    }
}
