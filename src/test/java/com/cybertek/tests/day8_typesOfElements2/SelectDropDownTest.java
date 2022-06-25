package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //locate your dropdown just like any other webelement with unique id
        WebElement dropdownElement=driver.findElement(By.id("state"));
        //create select object by passing that element as a constructor
        Select stateDropdown=new Select(dropdownElement);

        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        //verify that first selection is Select a state
        String selectedOption="Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,selectedOption,"verify first selection");

        //How to select options from dropdown
        //1.Select using visible text
        Thread.sleep(2000);
      stateDropdown.selectByVisibleText("Virginia");
       //how to verify
        selectedOption="Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,selectedOption,"verify first selection");

        //2.Select using index
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);
        selectedOption="Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,selectedOption,"verify first selection");

        //3.Select by value
        Thread.sleep(2000);
        stateDropdown.selectByValue("TX");
        selectedOption="Texas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,selectedOption,"verify first selection");
    }
}
