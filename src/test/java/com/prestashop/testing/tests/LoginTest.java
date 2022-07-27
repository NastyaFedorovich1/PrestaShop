package com.prestashop.testing.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void openLoginPage(){
        startpage.openPage();
        startpage.clickLogin();
        Assert.assertEquals(loginpage.getAuthenticationField(), "AUTHENTICATION");
    }

    @Test
    public void createAccount(){
        startpage.openPage();
        startpage.clickLogin();
        loginpage.setEmail("cod@mail.ru");
        loginpage.clickCreate();
        Assert.assertEquals(createaccountpage.getCreateField(), "CREATE AN ACCOUNT");
    }






}
