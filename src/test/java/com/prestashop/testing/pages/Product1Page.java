package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product1Page extends BasePage {

    public Product1Page(WebDriver driver){
        super(driver);
    }

    private By addToCartButton = By.xpath("//button[@name='Submit']");
    private By checkoutButton = By.xpath("//a[@title='Оформить заказ']");

    public WebElement getAddToCartButton(){
        return driver.findElement(addToCartButton);
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }

    public ShoppingCartSummaryPage addToCartClick(){
        getAddToCartButton().click();
        getCheckoutButton().click();
        return new ShoppingCartSummaryPage(driver);
    }
}
