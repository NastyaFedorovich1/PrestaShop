package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingPage extends BasePage {

    public ShippingPage(WebDriver driver){
        super(driver);
    }

    private By agreeWithTermsCheckbox = By.id("cgv");
    private By proceedToCheckoutButton = By.xpath("//span[contains(text(),'Proceed to checkout')]");
    private By errorMessage = By.className("fancybox-error");

    public WebElement getAgreeWithTerms(){
        return driver.findElement(agreeWithTermsCheckbox);
    }

    public WebElement getProceedToCheckoutButton(){
        return driver.findElement(proceedToCheckoutButton);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }
}