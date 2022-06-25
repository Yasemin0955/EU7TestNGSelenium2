package com.cybertek.tests.reviews.week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ScrollingTest {
    /*
    *  http://practice.cybertekschool.com/

    - P.I.Q.: How many ways do you know to scroll using Selenium?
    1. action.moveToElement().perform()
    2. PageUp, PageDown keys for scrolling

        action.sendKeys(Keys.PAGE_UP, PAGE_DOWN)

    3. jse.executeScript("window.scrollBy(0,250)");
    4. jse.executeScript("arguments[0].scrollIntoView(true)",cybertekSchoolLink);*/
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void movetoElementTest() throws InterruptedException {
        //scroll down by powered Cybertek School
        Actions actions=new Actions(driver);
        WebElement cybertek_school = driver.findElement(By.linkText("CYDEO"));
        Thread.sleep(5000);
        actions.moveToElement(cybertek_school).perform();
        Thread.sleep(3000);

        //advanced keyboard actions
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();//to take page up

        //2.way to scrolldown
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        Thread.sleep(1000);
    }
    @Test
    public void ScrollTestWithJSE() throws InterruptedException {
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        //3.way it scrolls all the way down
        jse.executeScript("window.scroll(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        jse.executeScript("window.scroll(0,- document.body.scrollHeight)");
        Thread.sleep(2000);

        //4.way to scroll up and down
        WebElement cybertek_school = driver.findElement(By.linkText("Cybertek School"));
        jse.executeScript("arguments[0].scrollIntoView(true)",cybertek_school);
        Thread.sleep(2000);

    }
}
