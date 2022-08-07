package BaseEntities;

import com.prestashop.testing.pages.*;
import com.prestashop.testing.steps.CartStep;
import com.prestashop.testing.steps.CreateAccountStep;
import com.prestashop.testing.steps.CreateAddressesStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    private WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginpage;
    protected StartPage startpage;
    protected CreateAccountPage createaccountpage;
    protected MyAccountPage myaccountpage;
    protected CreateAccountStep createAccountStep;
    protected WomenPage womenPage;
    protected ShoppingCartSummaryPage shoppingCartSummaryPage;
    protected CartStep cartStep;
    protected YourAddressesPage yourAddressesPage;
    protected CreateAddressesStep createAddressesStep;
    protected AddressesPage addressesPage;
    protected ShippingPage shippingPage;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginpage = new LoginPage(driver);
        startpage = new StartPage(driver);
        createaccountpage = new CreateAccountPage(driver);
        myaccountpage = new MyAccountPage(driver);
        createAccountStep = new CreateAccountStep(driver);
        womenPage = new WomenPage(driver);
        shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        cartStep = new CartStep(driver);
        yourAddressesPage = new YourAddressesPage(driver);
        createAddressesStep = new CreateAddressesStep(driver);
        addressesPage = new AddressesPage(driver);
        shippingPage = new ShippingPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}