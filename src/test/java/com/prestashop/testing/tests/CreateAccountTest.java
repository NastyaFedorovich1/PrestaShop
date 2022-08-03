package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccount() {
        startpage.openPage();
        startpage.clickLogin();
        loginpage.setEmail();
        loginpage.clickCreate();
        createAccountStep.fillNewAccountFields("man", "Mikita", "Fedorovich", "123456", "28", "2", "1998");
        createaccountpage.selectNewsletterCheckbox();
        createaccountpage.clickRegister();
        Assert.assertTrue(myaccountpage.getAccountCreateMessage().isDisplayed());
    }
}
