package com.cybertek.tests.reviews.week5;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsAndIframeTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
    }
    @AfterMethod
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void Test() throws InterruptedException {
        //switch to iframe
        WebElement iframe= driver.findElement(By.name("iframeResult"));
        driver.switchTo().frame(iframe);
        WebElement textDoubleclick= driver.findElement(By.id("demo"));
        Actions actions=new Actions(driver);
        actions.doubleClick(textDoubleclick) ;
        //accept cookies
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
        //4. Assert: Text’s “style” attribute value contains “red”.
        String expectedInStyle = "red";
        String actual = textDoubleclick.getAttribute("style");

        Assert.assertTrue(actual.contains(expectedInStyle));
    }
}
