package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createManAccountTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("man", "Mikita", "Fedorovich", "123456", "28", "2", "1998");
        createaccountpage.selectNewsletterCheckbox();
        createaccountpage.clickRegister();
        Assert.assertTrue(myaccountpage.getAccountCreateMessage().isDisplayed());
    }

    @Test
    public void createWomanAccountTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("woman", "Nastya", "Fedorovich", "879546", "2", "5", "1997");
        createaccountpage.clickRegister();
        Assert.assertTrue(myaccountpage.getAccountCreateMessage().isDisplayed());
    }

    @Test
    public void createAccountWithoutEmailTest(){
        startpage.openPage();
        startpage.clickLogin();
        loginpage.clickCreate();
        Assert.assertTrue(loginpage.getErrorMessage().isDisplayed());
    }

    @Test
    public void createAccountWithoutLastNameTest(){
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("woman", "Nastya", "Fedorovich", "", "2", "5", "1997");
        createaccountpage.clickRegister();
        Assert.assertTrue(createaccountpage.getErrorMessage().isDisplayed());
    }
}