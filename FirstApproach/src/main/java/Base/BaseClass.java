package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static Properties prop;
    public static WebDriver driver;

    public BaseClass()  {

        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("/Users/lazarvujovic/Desktop/lazar/FirstApproach/src/main/java/Configuration/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeDrivers(){

        String browserName = prop.getProperty("browser");

        switch (browserName) {
            case "chrome":

                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "safari":

                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "":
                throw new Error("Browser not defined.");

        }
        driver.manage().window().maximize();
    }
}
