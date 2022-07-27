package com.prestashop.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private By authenticationField = By.xpath("//*[text()='Authentication']");
    private By emailField = By.id("email_create");
    private By createButton = By.cssSelector(".icon-user.left");

    public String getAuthenticationField(){
        return driver.findElement(authenticationField).getText();
    }

    public WebElement getCreateButton(){
        return driver.findElement(createButton);
    }

    public LoginPage setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public CreateAccountPage clickCreate(){
        getCreateButton().click();
        return new CreateAccountPage(driver);
    }






}
