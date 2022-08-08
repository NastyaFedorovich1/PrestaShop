package com.prestashop.testing.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    WebDriver driver;
    String label;

    public Dropdown(WebDriver driver, String label){
        this.driver = driver;
        this.label = label;
    }

    public void select(String option){
        String openDropdownXpath = String.format("//div[@id='%s']",label);
        driver.findElement(By.xpath(openDropdownXpath)).click();
        driver.findElement(By.xpath(String.format(openDropdownXpath+"//option[@value='%s']", option))).click();
    }
}