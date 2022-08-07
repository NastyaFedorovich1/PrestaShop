package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends BasePage {

    public WomenPage(WebDriver driver){
        super(driver);
    }

    private By product1 = By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]");

    public Product1Page clickProduct1(){
        driver.findElement(product1).click();
        return new Product1Page(driver);
    }
}
