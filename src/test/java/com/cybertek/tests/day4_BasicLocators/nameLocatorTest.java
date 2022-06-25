package com.cybertek.tests.day4_BasicLocators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //to maximize the screen
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInput=driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("Mike Smith");

        //lazy way
        //driver.findElement(By.name("full_name")).sendKeys("Mike Smith");

        WebElement emailButton=driver.findElement(By.name("email"));
        emailButton.sendKeys("ymacit@gmail.com");
        WebElement signupButton=driver.findElement(By.name("wooden_spoon"));
        signupButton.click();
        //lazy way
        //driver.findElement(By.name("wooden_spoon")).click();
    }
}
