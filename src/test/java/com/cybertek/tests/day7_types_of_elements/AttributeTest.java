package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueRadioBtn= driver.findElement(By.id("blue"));
        System.out.println(blueRadioBtn.getAttribute("type"));
        System.out.println(blueRadioBtn.getAttribute("name"));
        System.out.println(blueRadioBtn.getAttribute("checked"));

        //trying to get attribute that does not exist
        //when we use non exist attribute it will retun NULL to us
        System.out.println(blueRadioBtn.getAttribute("href"));
        System.out.println(blueRadioBtn.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement button2= driver.findElement(By.name("button2"));
        System.out.println(button2.getAttribute("outerHTML"));
        String outerHTML = button2.getAttribute("outerHTML");
        Assert.assertTrue(outerHTML.contains("Button 2"));

        System.out.println("Inner HTML "+button2.getAttribute("innerHTML"));
        driver.quit();
    }
}
