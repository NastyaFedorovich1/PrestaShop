package com.prestashop.testing.steps;

import BaseEntities.BaseStep;
import com.prestashop.testing.User;
import com.prestashop.testing.pages.YourAddressesPage;
import com.prestashop.testing.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateAddressesStep extends BaseStep {

    public CreateAddressesStep(WebDriver driver){
        super(driver);
    }

    @Step("Fill Field Addresses")
    public void fillAddressesField(User user){

        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);

        yourAddressesPage.setFirstName(user.getFirstName());
        yourAddressesPage.setLastName(user.getLastName());
        yourAddressesPage.setAddressesField(user.getAddresses());
        yourAddressesPage.setPostCodeField(user.getPostCode());
        yourAddressesPage.setCityField(user.getCity());
        yourAddressesPage.setCountry(user.getCountry());
        yourAddressesPage.setPhoneField(user.getPhone());
        yourAddressesPage.setMobilePhone(user.getMobilePhone());
        yourAddressesPage.setState(user.getState());
        yourAddressesPage.setNameAddressesField(user.getNameAddresses());
        AllureUtils.takeScreenshot(driver);
    }
}