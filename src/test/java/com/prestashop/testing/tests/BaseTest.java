package com.prestashop.testing.tests;

import com.prestashop.testing.pages.CreateAccountPage;
import com.prestashop.testing.pages.LoginPage;
import com.prestashop.testing.pages.MyAccountPage;
import com.prestashop.testing.pages.StartPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    private WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginpage;
    protected StartPage startpage;
    protected CreateAccountPage createaccountpage;
    protected MyAccountPage myaccountpage;

    @BeforeMethod
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        loginpage = new LoginPage(driver);
        startpage = new StartPage(driver);
        createaccountpage = new CreateAccountPage(driver);
        myaccountpage = new MyAccountPage(driver);
    }
}
