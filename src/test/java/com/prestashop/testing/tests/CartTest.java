package com.prestashop.testing.tests;

import BaseEntities.BaseTest;
import com.prestashop.testing.User;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Add to Cart")
    @Description("Add to Cart T-Shirt")
    @Link(name = "Woman Page", url = "http://prestashop.qatestlab.com.ua/ru/3-women")
    public void AddToCartTest() {
        cartStep.addToCartTShirt();
        Assert.assertTrue(shoppingCartSummaryPage.getFadedShortSleeveTShirtField().isDisplayed());
    }

    @Test(description = "Delete Product from Cart")
    @Description("Add to Cart and delete Product from Cart")
    @Link(name = "Order Page", url = "http://prestashop.qatestlab.com.ua/ru/order")
    public void addToCartAndDeleteProductFromCartTest() {
        cartStep.addToCartTShirt();
        cartStep.deleteFromCart();
        Assert.assertTrue(shoppingCartSummaryPage.getEmptyCartMessage().isDisplayed());
    }

    @Test(description = "Order Product")
    @Description("All Product order Steps")
    @Link(name = "Order Page", url = "http://prestashop.qatestlab.com.ua/ru/order")
    public void OrderOneItemTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields(
                User.builder()
                        .gender("woman")
                        .firstName("Anastasia")
                        .lastName("Fedorovich")
                        .password("123456789")
                        .day("12")
                        .month("3")
                        .year("1997")
                        .build());
        createaccountpage.clickRegister();
        myaccountpage.getWomanButton().click();
        cartStep.addToCartTShirt();
        shoppingCartSummaryPage.getProceedToCheckoutButton().click();
        createAddressesStep.fillAddressesField(
                User.builder()
                        .firstName("Nastya")
                        .lastName("Fedorovich")
                        .addresses("New York")
                        .postCode("12345")
                        .city("New York")
                        .country("21")
                        .phone("895467")
                        .mobilePhone("5463132")
                        .state("32")
                        .nameAddresses("Test")
                        .build());
        yourAddressesPage.setSaveButton().click();
        addressesPage.getProceedToCheckoutButton().click();
        shippingPage.getAgreeWithTerms().click();
        shippingPage.getProceedToCheckoutButton().click();
        Assert.assertTrue(shoppingCartSummaryPage.getPaymentMessage().isDisplayed());
    }

    @Test(description = "Order Product without Terms Agreement")
    @Description("Order Product without Terms Agreement on Shipping Page")
    @Link(name = "Order Page", url = "http://prestashop.qatestlab.com.ua/ru/order")
    public void OrderOneItemWithoutTermsAgreementTest() {
        createAccountStep.proceedToAccountCreation();
        createAccountStep.fillNewAccountFields(
                User.builder()
                        .gender("woman")
                        .firstName("Anastasia")
                        .lastName("Fedorovich")
                        .password("123456789")
                        .day("12")
                        .month("3")
                        .year("1997")
                        .build());
        createaccountpage.clickRegister();
        myaccountpage.getWomanButton().click();
        cartStep.addToCartTShirt();
        shoppingCartSummaryPage.getProceedToCheckoutButton().click();
        createAddressesStep.fillAddressesField(
                User.builder()
                        .firstName("Nastya")
                        .lastName("Fedorovich")
                        .addresses("New York")
                        .postCode("12345")
                        .city("New York")
                        .country("21")
                        .phone("895467")
                        .mobilePhone("5463132")
                        .state("32")
                        .nameAddresses("Test")
                        .build());
        yourAddressesPage.setSaveButton().click();
        addressesPage.getProceedToCheckoutButton().click();
        shippingPage.getProceedToCheckoutButton().click();
        Assert.assertTrue(shippingPage.getErrorMessage().isDisplayed());
    }
}