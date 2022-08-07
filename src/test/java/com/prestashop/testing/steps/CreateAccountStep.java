package com.prestashop.testing.steps;

import BaseEntities.BaseStep;
import com.prestashop.testing.pages.CreateAccountPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateAccountStep extends BaseStep {

    public CreateAccountStep(WebDriver driver) {
        super(driver);
    }

    @Step("Fill field when create account")
    public void fillNewAccountFields(String gender, String firstName, String lastName, String password, String day, String month, String year) {
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        if (gender.equals("man")) {
            createAccountPage.selectMan();
        }else{
            createAccountPage.selectWoman();
        }
        createAccountPage.setFirstName(firstName);
        createAccountPage.setLastName(lastName);
        createAccountPage.setPassword(password);
        createAccountPage.setDay(day);
        createAccountPage.setMonth(month);
        createAccountPage.setYear(year);
    }
}
