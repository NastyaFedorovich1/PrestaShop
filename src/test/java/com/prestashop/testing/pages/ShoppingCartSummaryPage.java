package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartSummaryPage extends BasePage {

    public ShoppingCartSummaryPage(WebDriver driver){
        super(driver);
    }

    private By proceedToCheckoutButton = By.xpath("//span[contains(text(),'Proceed to checkout')]");
    private By fadedShortSleeveTShirtField = By.xpath("//td[@class='cart_description']//a[contains(text(), 'Faded Short Sleeve T-shirts')]");
    private By deleteButton = By.className("icon-trash");
    private By emptyCartMessage = By.cssSelector(".alert.alert-warning");
    private By paymentMessage = By.xpath("//p[contains(text(),'No payment modules have been installed.')]");

    public WebElement getProceedToCheckoutButton(){
        return driver.findElement(proceedToCheckoutButton);
    }

    public WebElement getFadedShortSleeveTShirtField(){
        return driver.findElement(fadedShortSleeveTShirtField);
    }

    public WebElement getEmptyCartMessage(){
        return driver.findElement(emptyCartMessage);
    }

    public WebElement getDeleteButton(){
        return driver.findElement(deleteButton);
    }

    public WebElement getPaymentMessage(){
        return driver.findElement(paymentMessage);
    }
}
