package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Add to Cart")
    @Description("Add to Cart T-Shirt")
    @Link("http://prestashop.qatestlab.com.ua/ru/3-women")
    public void AddToCartTest(){
        cartStep.addToCartTShirt();
        Assert.assertTrue(shoppingCartSummaryPage.getFadedShortSleeveTShirtField().isDisplayed());
    }

    @Test(description = "Delete Product from Cart")
    @Description("Add to Cart and delete Product from Cart")
    @Link("http://prestashop.qatestlab.com.ua/ru/order")
    public void addToCartAndDeleteProductFromCartTest(){
        cartStep.addToCartTShirt();
        cartStep.deleteFromCart();
        Assert.assertTrue(shoppingCartSummaryPage.getEmptyCartMessage().isDisplayed());
    }

    @Test(description = "Order Product")
    @Description("All Product order Steps")
    @Link("http://prestashop.qatestlab.com.ua/ru/order")
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

    @Test(description = "Order Product without Terms Agreement")
    @Description("Order Product without Terms Agreement on Shipping Page")
    @Link("http://prestashop.qatestlab.com.ua/ru/order")
    public void OrderOneItemWithoutTermsAgreementTest(){
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