package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {

    @Test(description = "Create man Account")
    @Description("Create man Account")
    @Link(name = "Create account", url = "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account#account-creation")
    public void createManAccountTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("man");
        createaccountpage.selectNewsletterCheckbox();
        createaccountpage.clickRegister();
        Assert.assertTrue(myaccountpage.getAccountCreateMessage().isDisplayed());
    }

    @Test(description = "Create woman Account")
    @Description("Create woman Account")
    @Link(name = "Create account", url = "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account#account-creation")
    public void createWomanAccountTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("woman");
        createaccountpage.clickRegister();
        Assert.assertTrue(myaccountpage.getAccountCreateMessage().isDisplayed());
    }

    @Test(description = "Create Account Negative Test")
    @Description("Create Account without e-mail")
    @Link(name = "Login Page", url = "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account")
    public void createAccountWithoutEmailTest(){
        startpage.openPage();
        startpage.clickLogin();
        loginpage.clickCreate();
        Assert.assertTrue(loginpage.getErrorMessage().isDisplayed());
    }

    @Test(description = "Create Account Negative Test")
    @Description("Create Account without Last Name")
    @Link(name = "Create account", url = "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account#account-creation")
    public void createAccountWithoutLastNameTest(){
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFieldsWithoutEmail();
        createaccountpage.clickRegister();
        Assert.assertTrue(createaccountpage.getErrorMessage().isDisplayed());
    }
}