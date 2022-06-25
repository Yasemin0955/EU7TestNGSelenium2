package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //locating radio button

        WebElement blueRadioBtn= driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioBtn= driver.findElement(By.id("red"));
        System.out.println("blueRadioBtn.isSelected() = " + blueRadioBtn.isSelected());
        System.out.println("redRadioBtn.isSelected() = " + redRadioBtn.isSelected());



        //verify blue is selected red is not selected
        Assert.assertTrue(blueRadioBtn.isSelected(),"Verify blue is selected");
        Assert.assertFalse(redRadioBtn.isSelected(),"Verify red is not selected");

        //how to click radio button
        redRadioBtn.click();
        //verify red is selected red is not selected
        Assert.assertFalse(blueRadioBtn.isSelected(),"Verify blue is NOT selected");
        Assert.assertTrue(redRadioBtn.isSelected(),"Verify red is  selected");






        Thread.sleep(3000);
        driver.quit();
    }
}
