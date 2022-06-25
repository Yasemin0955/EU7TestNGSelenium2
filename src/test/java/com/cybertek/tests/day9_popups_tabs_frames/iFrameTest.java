package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest { WebDriver driver;
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
        driver.get("http://practice.cybertekschool.com/iframe");

        //how to switch to frame
        //1.wayby using name or id attribue of frame
        driver.switchTo().frame("mce_0_ifr");

        //clear before send keys
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith");

        //1.way=switch back from small html
        //goes back to first frame(main html)
        driver.switchTo().defaultContent();

        //2.way using index
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("#tinymce")).clear();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with Index");

        //second way of going back to parent frame
        driver.switchTo().parentFrame();

        //3.way switch to frame
        //using webelement
        //locating iframe with a valid locator
        WebElement iFrameElement= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElement);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Mike Smith with WEBELEMENT");


    }
    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");

        //under top we have 3 frames which are right middle and left
        //switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());
        //go back to top frame
        driver.switchTo().parentFrame();
        //switch to rigth frame with index
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch to bottom
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }

}
