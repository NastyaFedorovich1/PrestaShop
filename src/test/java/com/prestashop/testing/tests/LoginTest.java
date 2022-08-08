package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import com.prestashop.testing.utils.AllureUtils;
import io.qameta.allure.Link;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Open Login Page")
    @Description("Check or the page opens")
    @Link("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void openLoginPageTest() {
        startpage.openPage();
        startpage.clickLogin();
        Assert.assertEquals(loginpage.getAuthenticationField(), "AUTHENTICATION");
    }
}