package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Browsers {
    private WebDriver driver = null;

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                optionsFirefox.addArguments("--start-maximized");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(optionsFirefox);
                break;

        }

        return driver;

    }
}