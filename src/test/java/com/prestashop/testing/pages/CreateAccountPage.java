package com.prestashop.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private By createField = By.xpath("//*[text()='Create an account']");
    private By manField = By.id("id_gender1");
    private By womanField = By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By dayField = By.id("days");
    private By monthField = By.id("months");
    private By yearField = By.id("cuselFrame-years");
    private By registerButton = By.name("Register");

    public String getCreateField() {
        return driver.findElement(createField).getText();
    }

    public WebElement getRegisterButton() {
        return driver.findElement(registerButton);
    }

    public CreateAccountPage setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public CreateAccountPage setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CreateAccountPage setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    Select dropdownDay = new Select(driver.findElement(dayField));
    List<WebElement> dropdownDayList = dropdownDay.getOptions();

    public CreateAccountPage setDays(String day){
        dropdownDay.selectByValue(day);
        return this;
    }

    Select dropdownMonth = new Select(driver.findElement(monthField));
    List<WebElement> dropdownMonthList = dropdownMonth.getOptions();

    public CreateAccountPage setMonth(String month){
        dropdownMonth.selectByValue(month);
        return this;
    }

    Select dropdownYears = new Select(driver.findElement(yearField));
    List<WebElement> getDropdownYearsList = dropdownYears.getOptions();

    public CreateAccountPage setYears(String years){
        dropdownYears.selectByValue(years);
        return this;
    }

    public MyAccountPage clickRegister() {
        getRegisterButton().click();
        return new MyAccountPage(driver);
    }


}
