package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import propertyFileReader.ReadPropertyFile;

import java.io.IOException;

public class BrowserFactory {
    static WebDriver driver;
    static ReadPropertyFile propertyFile;

    public static WebDriver startBrowser(String browserName, String url) throws IOException {
        if(browserName.equalsIgnoreCase("firefox")){
            propertyFile = new ReadPropertyFile();
            System.setProperty(propertyFile.getPropertiesKey(), propertyFile.getPropertiesValue());
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else {
            driver = new InternetExplorerDriver();
        }

        System.out.println("Test started");
        driver.manage().window().maximize();
        driver.get(url);

        return driver;
    }
}
