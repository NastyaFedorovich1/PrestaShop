package com.prestashop.testing.pages;

import BaseEntities.BasePage;
import com.prestashop.testing.wrappers.Dropdown;
import com.prestashop.testing.wrappers.SelectCityAndState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesPage extends BasePage {

    public YourAddressesPage(WebDriver driver){
        super(driver);
    }

    protected By firstNameField = By.id("firstname");
    protected By lastNameField = By.id("lastname");
    protected By addressesField = By.id("address1");
    protected By postCodeField = By.id("postcode");
    protected By cityField = By.id("city");
    protected By country = By.id("id_country");
    protected By phoneField = By.id("phone");
    protected By mobilePhoneField = By.id("phone_mobile");
    protected By state = By.id("id_state");
    protected By nameAddressesField = By.id("alias");
    protected By saveButton = By.xpath("//span[contains(text(),'Save')]");

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddressesField(String addresses) {
        driver.findElement(addressesField).sendKeys(addresses);
    }

    public void setPostCodeField(String postCode) {
        driver.findElement(postCodeField).sendKeys(postCode);
    }

    public void setCityField(String city) { driver.findElement(cityField).sendKeys(city); }

    public void setCountry(String city){
        new SelectCityAndState(driver, "uniform-id_country").select(city);
    }

    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void setMobilePhone(String mobilePhone) {
        driver.findElement(mobilePhoneField).sendKeys(mobilePhone);
    }

    public void setState(String state){
        new SelectCityAndState(driver, "uniform-id_state").select(state);
    }

    public void setNameAddressesField(String nameAddresses) {
        driver.findElement(nameAddressesField).sendKeys(nameAddresses);
    }

    public WebElement setSaveButton(){
       return driver.findElement(saveButton);
    }
}
