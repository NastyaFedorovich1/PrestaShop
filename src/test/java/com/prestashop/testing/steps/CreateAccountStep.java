package com.prestashop.testing.steps;

import BaseEntities.BaseStep;
import com.prestashop.testing.User;
import com.prestashop.testing.pages.CreateAccountPage;
import com.prestashop.testing.pages.LoginPage;
import com.prestashop.testing.pages.StartPage;
import com.prestashop.testing.utils.AllureUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CreateAccountStep extends BaseStep {

    public CreateAccountStep(WebDriver driver) {
        super(driver);
    }

    @Step("Proceed to Account Creation")
    public void proceedToAccountCreation() {
        StartPage startPage = new StartPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        startPage.openPage();
        startPage.clickLogin();
        loginPage.setEmail();
        loginPage.clickCreate();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Fill field when create account")
    public void fillNewAccountFields(User user) {

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        if (user.getGender().equals("man")) {
            createAccountPage.selectMan();
        } else {
            createAccountPage.selectWoman();
        }
        createAccountPage.setFirstName(user.getFirstName());
        createAccountPage.setLastName(user.getLastName());
        createAccountPage.setPassword(user.getPassword());
        createAccountPage.setDay(user.getDay());
        createAccountPage.setMonth(user.getMonth());
        createAccountPage.setYear(user.getYear());

        AllureUtils.takeScreenshot(driver);
    }

    @Step("Fill field when create account without last name")
    public void fillNewAccountFieldsWithoutLastName(User user) {

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        createAccountPage.selectWoman();
        createAccountPage.setFirstName(user.getFirstName());
        createAccountPage.setPassword(user.getPassword());
        createAccountPage.setDay(user.getDay());
        createAccountPage.setMonth(user.getMonth());
        createAccountPage.setYear(user.getYear());

        AllureUtils.takeScreenshot(driver);
    }
}