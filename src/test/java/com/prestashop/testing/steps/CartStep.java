package com.prestashop.testing.steps;

import BaseEntities.BaseStep;
import com.prestashop.testing.pages.ShoppingCartSummaryPage;
import com.prestashop.testing.pages.StartPage;
import com.prestashop.testing.pages.WomenPage;
import com.prestashop.testing.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartStep extends BaseStep {

    public CartStep(WebDriver driver) {
        super(driver);
    }

    @Step("Add to Cart T-Shirt")
    public void addToCartTShirt() {
        StartPage startPage = new StartPage(driver);
        WomenPage womenPage = new WomenPage(driver);

        startPage.openPage();
        startPage.getWomenButton().click();
        womenPage.clickAddToCartTShirtButton();
        womenPage.checkoutClick();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Delete from Cart")
    public void deleteFromCart() {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        shoppingCartSummaryPage.getDeleteButton().click();
        wait.until(ExpectedConditions.invisibilityOf(shoppingCartSummaryPage.getFadedShortSleeveTShirtField()));
        driver.navigate().refresh();
        AllureUtils.takeScreenshot(driver);
    }
}
