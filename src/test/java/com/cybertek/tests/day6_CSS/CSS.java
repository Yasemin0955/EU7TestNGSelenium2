package com.cybertek.tests.day6_CSS;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CSS {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement dontclickButton= driver.findElement(By.cssSelector("#disappearing_button"));
        System.out.println(dontclickButton.getText());
        driver.quit();
    }
}
