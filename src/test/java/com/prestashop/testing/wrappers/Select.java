package com.prestashop.testing.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Select {

    WebDriver driver;
    String label;

    public Select(WebDriver driver, String label){
        this.driver = driver;
        this.label = label;
    }

    public void select(String option){

        driver.findElement(By.xpath(String.format("//div[@id='%s']",label))).click();
        driver.findElement(By.xpath(String.format("//option[@value='%s']", option))).click();
    }
}