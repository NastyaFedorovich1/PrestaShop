package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void openLoginPage() {
        startpage.openPage();
        startpage.clickLogin();
        Assert.assertEquals(loginpage.getAuthenticationField(), "AUTHENTICATION");
    }
}
