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
    public void fillNewAccountFields(String gender) {

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        User man = User.builder()
                .gender("man")
                .firstName("Nikita")
                .lastName("Fedorovich")
                .password("123456789")
                .day("2")
                .month("2")
                .year("1998")
                .build();

        User woman = User.builder()
                .gender("woman")
                .firstName("Nastya")
                .lastName("Fedorovich")
                .password("87654321")
                .day("12")
                .month("3")
                .year("1997")
                .build();

        if (gender.equals("man")) {
            createAccountPage.selectMan();
            createAccountPage.setFirstName(man.getFirstName());
            createAccountPage.setLastName(man.getLastName());
            createAccountPage.setPassword(man.getPassword());
            createAccountPage.setDay(man.getDay());
            createAccountPage.setMonth(man.getMonth());
            createAccountPage.setYear(man.getYear());
        } else {
            createAccountPage.selectWoman();
            createAccountPage.setFirstName(woman.getFirstName());
            createAccountPage.setLastName(woman.getLastName());
            createAccountPage.setPassword(woman.getPassword());
            createAccountPage.setDay(woman.getDay());
            createAccountPage.setMonth(woman.getMonth());
            createAccountPage.setYear(woman.getYear());
        }
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Fill field when create account without last name")
    public void fillNewAccountFieldsWithoutEmail() {

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);

        User woman = User.builder()
                .gender("woman")
                .firstName("Nastya")
                .lastName("Fedorovich")
                .password("87654321")
                .day("12")
                .month("3")
                .year("1997")
                .build();

            createAccountPage.selectWoman();
            createAccountPage.setFirstName(woman.getFirstName());
            createAccountPage.setPassword(woman.getPassword());
            createAccountPage.setDay(woman.getDay());
            createAccountPage.setMonth(woman.getMonth());
            createAccountPage.setYear(woman.getYear());

            AllureUtils.takeScreenshot(driver);
    }
}