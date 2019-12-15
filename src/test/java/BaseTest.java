import locators.CheckoutLocators;
import locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    static WebDriver driver;
    static HomePageLocators home;
    static CheckoutLocators checkout;

    @BeforeClass
    public  void setUpTest() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://shopcart-challenge.4all.com/");
        home = new HomePageLocators(driver);
        checkout = new CheckoutLocators(driver);
    }

    @AfterTest
    public void finalizarTest(){
        driver.close();
        driver.quit();

    }
}
