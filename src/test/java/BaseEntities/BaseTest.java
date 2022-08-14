package BaseEntities;

import com.prestashop.testing.User;
import com.prestashop.testing.pages.*;
import com.prestashop.testing.steps.CartStep;
import com.prestashop.testing.steps.CreateAccountStep;
import com.prestashop.testing.steps.CreateAddressesStep;
import com.prestashop.testing.utils.PropertyReader;
import com.prestashop.testing.utils.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListener.class)
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
    public void setUp(ITestContext context){

        PropertyReader propertyReader = new PropertyReader();
        User user = new User();
        long time = propertyReader.getTimeout();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

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

        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser () {
        if (driver != null) {
            driver.quit();
        }
    }
}