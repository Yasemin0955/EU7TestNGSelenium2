package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
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
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our web elements in the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());


        //verify button size
        Assert.assertEquals(buttons.size(),6,"verify buttons size");

        //iter+enter to get the for each loop with shortcut
        for (WebElement button : buttons) {
            System.out.println(button.getText());

            //verify each button is displayed
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(),"buttons are not displayed");
        }


        //to click the second button
        buttons.get(1).click();
    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        //passing wrong locator it wont throw no such element error it will return empty list
        List<WebElement> buttons2 = driver.findElements(By.tagName("buttonfgghj"));
        System.out.println("buttons2.size() = " + buttons2.size());//size=0
    }
}
