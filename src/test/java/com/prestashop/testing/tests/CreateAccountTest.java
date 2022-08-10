package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    @Test(description = "Create man Account")
    @Description("Create man Account")
    @Link("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void createManAccountTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("man", "Mikita", "Fedorovich", "123456", "28", "2", "1998");
        createaccountpage.selectNewsletterCheckbox();
        createaccountpage.clickRegister();
        Assert.assertTrue(myaccountpage.getAccountCreateMessage().isDisplayed());
    }

    @Test(description = "Create woman Account")
    @Description("Create woman Account")
    @Link("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void createWomanAccountTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("woman", "Nastya", "Fedorovich", "879546", "2", "5", "1997");
        createaccountpage.clickRegister();
        Assert.assertTrue(myaccountpage.getAccountCreateMessage().isDisplayed());
    }

    @Test(description = "Create Account Negative Test")
    @Description("Create Account without e-mail")
    @Link("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void createAccountWithoutEmailTest(){
        startpage.openPage();
        startpage.clickLogin();
        loginpage.clickCreate();
        Assert.assertTrue(loginpage.getErrorMessage().isDisplayed());
    }

    @Test(description = "Create Account Negative Test")
    @Description("Create Account without Last Name")
    @Link("http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void createAccountWithoutLastNameTest(){
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("woman", "Nastya", "Fedorovich", "", "2", "5", "1997");
        createaccountpage.clickRegister();
        Assert.assertTrue(createaccountpage.getErrorMessage().isDisplayed());
    }
}