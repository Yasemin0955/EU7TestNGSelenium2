package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {
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
        WebElement dropdownElement=driver.findElement(By.id("dropdownMenuLink"));
        //click the dropdown to see the available options
        dropdownElement.click();

        //get the options by find elemnts method and finding common locator between them
        List<WebElement> dropdownOptions = driver.findElements(By.className("dropdown-item"));

        //print size of options
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());

        //print them one by one
        for (WebElement dropdownOption : dropdownOptions) {
            System.out.println(dropdownOption.getText());

            //click Yahoo by index
            dropdownOptions.get(2).click();

        }



    }
}
