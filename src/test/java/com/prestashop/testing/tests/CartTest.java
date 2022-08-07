package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void AddToCart(){
        cartStep.addToCartTShirt();
        Assert.assertTrue(shoppingCartSummaryPage.getFadedShortSleeveTShirtField().isDisplayed());
    }

    @Test
    public void addToCartAndDeleteProductFromCart(){
        cartStep.addToCartTShirt();
        cartStep.deleteFromCart();
        Assert.assertTrue(shoppingCartSummaryPage.getEmptyCartMessage().isDisplayed());
    }

    @Test
    public void OrderOneItemTest(){
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("woman", "Nastya", "Fedorovich", "555888",
                "2", "5", "1997");
        createaccountpage.clickRegister();
        myaccountpage.getWomanButton().click();
        cartStep.addToCartTShirt();
        shoppingCartSummaryPage.getProceedToCheckoutButton().click();
        createAddressesStep.fillAddressesField("Nastya", "Fedorovich", "New York",
                "12345", "New York", "21", "895467", "5463132", "32",
                "Test");
        yourAddressesPage.setSaveButton().click();
        addressesPage.getProceedToCheckoutButton().click();
        shippingPage.getAgreeWithTerms().click();
        shippingPage.getProceedToCheckoutButton().click();
        Assert.assertTrue(shoppingCartSummaryPage.getPaymentMessage().isDisplayed());
    }

    @Test
    public void OrderOneItemWithoutTermsAgreement(){
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields("woman", "Nastya", "Fedorovich", "555888",
                "2", "5", "1997");
        createaccountpage.clickRegister();
        myaccountpage.getWomanButton().click();
        cartStep.addToCartTShirt();
        shoppingCartSummaryPage.getProceedToCheckoutButton().click();
        createAddressesStep.fillAddressesField("Nastya", "Fedorovich", "New York",
                "12345", "New York", "21", "895467", "5463132", "32",
                "Test");
        yourAddressesPage.setSaveButton().click();
        addressesPage.getProceedToCheckoutButton().click();
        shippingPage.getProceedToCheckoutButton().click();
        Assert.assertTrue(shippingPage.getErrorMessage().isDisplayed());
    }
}