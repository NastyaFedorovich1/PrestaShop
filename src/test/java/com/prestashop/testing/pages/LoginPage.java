package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private By authenticationField = By.xpath("//*[text()='Authentication']");
    private By emailField = By.id("email_create");
    private By createButton = By.cssSelector(".icon-user.left");
    private By errorMessage = By.xpath("//li[contains(text(),'Invalid email address.')]");

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public String getAuthenticationField(){
        return driver.findElement(authenticationField).getText();
    }
    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }

    public WebElement getCreateButton(){
        return driver.findElement(createButton);
    }

    public LoginPage setEmail(){
        String email = fakeValuesService.bothify("????##@gmail.com");
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public CreateAccountPage clickCreate(){
        getCreateButton().click();
        return new CreateAccountPage(driver);
    }
}
