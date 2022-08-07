package com.prestashop.testing.steps;

import BaseEntities.BaseStep;
import com.prestashop.testing.pages.YourAddressesPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateAddressesStep extends BaseStep {

    public CreateAddressesStep(WebDriver driver){
        super(driver);
    }

    @Step("Fill Field Addresses")
    public void fillAddressesField(String firstName, String lastName, String addresses, String postCode, String city,
                                   String country, String phone, String mobilePhone, String state, String nameAddresses){

        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);

        yourAddressesPage.setFirstName(firstName);
        yourAddressesPage.setLastName(lastName);
        yourAddressesPage.setAddressesField(addresses);
        yourAddressesPage.setPostCodeField(postCode);
        yourAddressesPage.setCityField(city);
        yourAddressesPage.setCountry(country);
        yourAddressesPage.setPhoneField(phone);
        yourAddressesPage.setMobilePhone(mobilePhone);
        yourAddressesPage.setState(state);
        yourAddressesPage.setNameAddressesField(nameAddresses);
    }
}
