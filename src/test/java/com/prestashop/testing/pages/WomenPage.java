package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WomenPage extends BasePage {

    public WomenPage(WebDriver driver){
        super(driver);
    }

    private By productTShirts = By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]");
    private By addToCartTShirtsButton = By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]/following::a[@title='Add to cart'][1]");
    private By goToShoppingCartSummary = By.xpath("//div[@class='layer_cart_cart col-xs-12 col-md-6']//span[contains(text(),'Оформить заказ')]");

    Actions action = new Actions(driver);

    public void clickProduct1(){
        action.moveToElement(driver.findElement(productTShirts)).moveToElement(driver.findElement(addToCartTShirtsButton)).click().build().perform();
    }

    public void checkoutClick(){
        driver.findElement(goToShoppingCartSummary).click();
    }


}
