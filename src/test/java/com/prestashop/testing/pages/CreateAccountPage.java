package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import com.prestashop.testing.utils.AllureUtils;
import com.prestashop.testing.wrappers.Dropdown;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

@Log4j2
public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    private By createField = By.xpath("//*[text()='Create an account']");
    private By manButton = By.id("uniform-id_gender1");
    private By womanButton = By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By dayField = By.id("days");
    private By monthField = By.id("months");
    private By yearField = By.id("cuselFrame-years");
    private By registerButton = By.xpath("//span[text()='Register']");
    private By newsletterCheckbox = By.id("newsletter");
    private By errorMessage = By.xpath("//p[contains(text(), 'There is 1 error')]");

    Actions action = new Actions(driver);

    public String getCreateField() {
        return driver.findElement(createField).getText();
    }

    public WebElement getRegisterButton() {
        return driver.findElement(registerButton);
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }

    public void selectMan(){
        driver.findElement(manButton).click();
    }

    public void selectWoman(){
        driver.findElement(womanButton).click();
    }

    public void setFirstName(String firstName) {
        log.info("Set {} first name for login", firstName);
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        log.info("Set {} last name for login", lastName);
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setPassword(String password) {
        log.info("Set {} password for login", password);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setDay(String day){
        log.info("Set {} day for login", day);
        new Dropdown(driver, "uniform-days").select(day);
    }

    public void setMonth(String month){
        log.info("Set {} month for login", month);
        new Dropdown(driver, "uniform-months").select(month);
    }

    public void setYear(String year){
        log.info("Set {} year for login", year);
        driver.findElement(By.xpath("//div[@id='cuselFrame-years']")).click();
        WebElement yearSelect = driver.findElement(By.xpath(String.format("//span[@val='%s']", year)));
        action.moveToElement(yearSelect).build().perform();
        yearSelect.click();
    }

    public void selectNewsletterCheckbox(){
        driver.findElement(newsletterCheckbox).click();
    }

    public void clickRegister() {
        getRegisterButton().click();
    }
}