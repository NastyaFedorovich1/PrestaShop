package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage extends BasePage {

    public AddressesPage(WebDriver driver){
        super(driver);
    }

    private By proceedToCheckoutButton = By.xpath("//span[contains(text(),'Proceed to checkout')]");

    public WebElement getProceedToCheckoutButton(){
        return driver.findElement(proceedToCheckoutButton);
    }
}