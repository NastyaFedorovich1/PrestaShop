package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver){
        super(driver);
    }

    private By logInButton = By.className("login");
    private By womenButton = By.className("sf-with-ul");
    private By emailField = By.id("newsletter-input");
    private By confirmButton = By.name("submitNewsletter");
    private By successMessage = By.cssSelector(".alert.alert-success");
    private By errorMessage = By.cssSelector(".alert.alert-danger");

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public void openPage(){
        driver.get("http://prestashop.qatestlab.com.ua/ru/");
    }

    public WebElement getLogInButton(){
        return driver.findElement(logInButton);
    }

    public WebElement getWomenButton(){
        return driver.findElement(womenButton);
    }

    public WebElement getConfirmButton(){
        return driver.findElement(confirmButton);
    }

    public LoginPage clickLogin(){
        getLogInButton().click();
        return new LoginPage(driver);
    }

    public LoginPage clickConfirm(){
        getConfirmButton().click();
        return new LoginPage(driver);
    }

    public StartPage setRandomEmail(){
        String email = fakeValuesService.bothify("????##@gmail.com");
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public StartPage setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public String getSuccessMessage(){
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }
}