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
    public void fillAddressesField(){

        YourAddressesPage yourAddressesPage = new YourAddressesPage(driver);

        User woman = User.builder()
                .firstName("Nastya")
                .lastName("Fedorovich")
                .addresses("New York")
                .postCode("12345")
                .city("New York")
                .country("21")
                .phone("895467")
                .mobilePhone("5463132")
                .state("32")
                .nameAddresses("Test")
                .build();

        yourAddressesPage.setFirstName(woman.getFirstName());
        yourAddressesPage.setLastName(woman.getLastName());
        yourAddressesPage.setAddressesField(woman.getAddresses());
        yourAddressesPage.setPostCodeField(woman.getPostCode());
        yourAddressesPage.setCityField(woman.getCity());
        yourAddressesPage.setCountry(woman.getCountry());
        yourAddressesPage.setPhoneField(woman.getPhone());
        yourAddressesPage.setMobilePhone(woman.getMobilePhone());
        yourAddressesPage.setState(woman.getState());
        yourAddressesPage.setNameAddressesField(woman.getNameAddresses());
        AllureUtils.takeScreenshot(driver);
    }
}