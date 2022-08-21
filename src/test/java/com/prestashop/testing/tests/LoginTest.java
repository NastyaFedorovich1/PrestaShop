package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import com.prestashop.testing.utils.Retry;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Open Login Page", retryAnalyzer = Retry.class)
    @Description("Check or the page opens")
    @Link(name = "Login Page", url = "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void openLoginPageTest() {
        startpage.openPage();
        startpage.clickLogin();
        Assert.assertEquals(loginpage.getAuthenticationField(), "AUTHENTICATION");
    }

    @Test(description = "Successful newsletter subscription")
    @Description("Insert correct email")
    @Link(name = "Start Page", url = "http://prestashop.qatestlab.com.ua/ru/")
    public void newsletterSubscriptionSuccess(){
        startpage.openPage();
        startpage.setRandomEmail();
        startpage.clickConfirm();
        Assert.assertEquals(startpage.getSuccessMessage(), "Рассылка: Успешная подписка");
    }

    @Test(description = "Unsuccessful newsletter subscription")
    @Description("Insert incorrect email")
    @Link(name = "Start Page", url = "http://prestashop.qatestlab.com.ua/ru/")
    public void newsletterSubscriptionError(){
        startpage.openPage();
        startpage.setEmail("rt");
        startpage.clickConfirm();
        Assert.assertEquals(startpage.getErrorMessage(), "Рассылка: Неверный адрес e-mail");
    }
}