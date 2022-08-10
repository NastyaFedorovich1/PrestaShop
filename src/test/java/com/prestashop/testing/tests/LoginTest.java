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
    @Link("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void openLoginPageTest() {
        startpage.openPage();
        startpage.clickLogin();
        Assert.assertEquals(loginpage.getAuthenticationField(), "5AUTHENTICATION");
    }
}