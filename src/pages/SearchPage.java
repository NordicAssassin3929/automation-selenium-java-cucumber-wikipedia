package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage{
    WebDriver driver;
    By searchBar = By.name("search");
    By searchButton = By.xpath("//button[@type='submit']");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterSearch(String searchInput){
        driver.findElement(searchBar).sendKeys(searchInput);
    }

    public void clickSearch(){
        driver.findElement(searchButton).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("Porsche"));
    }

    public void closeDriver(){
        driver.close();
    }
}
