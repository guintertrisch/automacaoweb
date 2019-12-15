import locators.CheckoutLocators;
import locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.Browsers;

@Listeners({utils.Listeners.class})
public abstract class BaseTest {
    public WebDriver driver;
    public HomePageLocators home;
    public CheckoutLocators checkout;
    Browsers browsers = new Browsers();

    @BeforeMethod
    @Parameters("browser")
    public void setUpTest(@Optional("firefox") String browser) {
        driver = browsers.getDriver(browser);
        driver.get("https://shopcart-challenge.4all.com/");
        home = new HomePageLocators(driver);
        checkout = new CheckoutLocators(driver);

    }

    @AfterMethod
    public void finalizarTest() {
        driver.close();
    }


}
