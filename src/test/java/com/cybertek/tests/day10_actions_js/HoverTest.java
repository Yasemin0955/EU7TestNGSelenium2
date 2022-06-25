package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverTest {
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
    public void test() throws InterruptedException {
        /*
        * hover over each image in the website
        * verify each name :user text is displayed
        * */
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1= driver.findElement(By.tagName("img"));

        Actions actions=new Actions(driver);

        Thread.sleep(2000);
        actions.moveToElement(img1).perform();


       for(int i=1;i<=3;i++){
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           WebElement img= driver.findElement(By.xpath("(//img)["+i+"]"));
           Actions action=new Actions(driver);
           action.moveToElement(img).perform();
           WebElement text= driver.findElement(By.xpath("(//h5)["+i+"]"));
           Assert.assertTrue(text.isDisplayed(),"text is not displayed");
       }
    }
}
