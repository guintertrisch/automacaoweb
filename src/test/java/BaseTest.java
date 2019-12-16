import locators.CheckoutLocators;
import locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Browsers;

@Listeners({utils.Listeners.class})
public abstract class BaseTest {
    public WebDriver driver;
    public HomePageLocators home;
    public CheckoutLocators checkout;


    @BeforeMethod
    @Parameters("browser")
    public void setUpTest(@Optional("chrome") String browser) {
        Browsers browsers = new Browsers();
        driver = browsers.getDriver(browser);
        driver.get("https://shopcart-challenge.4all.com/");
        home = new HomePageLocators(driver);
        checkout = new CheckoutLocators(driver);

    }

    @AfterMethod
    public void browserClose() {
        driver.close();
    }

}
