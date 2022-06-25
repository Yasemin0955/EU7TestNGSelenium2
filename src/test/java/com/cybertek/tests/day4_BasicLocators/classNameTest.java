package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class classNameTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement homeLink= driver.findElement(By.className("nav-link"));
        homeLink.click();

        //lazy way of print multiple headers
        System.out.println(driver.findElement(By.className("h3")).getText());
    }
}
