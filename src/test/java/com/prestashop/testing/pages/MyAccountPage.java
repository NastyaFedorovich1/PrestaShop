package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    private By accountField = By.className("page-heading");
    private By accountCreated = By.xpath("//p[contains(text(),'Your account has been created')]");

    public WebElement getAccountCreateMessage(){
        return driver.findElement(accountCreated);
    }
}
