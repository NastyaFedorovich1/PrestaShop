package com.prestashop.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage{

    public StartPage(WebDriver driver){
        super(driver);
    }

    private By logInButton = By.className("login");

    public void openPage(){
        driver.get("http://prestashop.qatestlab.com.ua/ru/");
    }

    public WebElement getLogInButton(){
        return driver.findElement(logInButton);
    }

    public LoginPage clickLogin(){
        getLogInButton().click();
        return new LoginPage(driver);
    }



}
