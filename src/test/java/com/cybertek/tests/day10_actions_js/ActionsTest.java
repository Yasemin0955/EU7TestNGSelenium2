package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
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
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1= driver.findElement(By.tagName("img"));

        Actions actions=new Actions(driver);

        Thread.sleep(2000);
        actions.moveToElement(img1).perform();

        WebElement viewLink= driver.findElement(By.linkText("View profile"));
        Assert.assertTrue(viewLink.isDisplayed(),"Link is not displayed");
    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
         //accept cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        actions.dragAndDrop(source,target).perform();
    }
    @Test
    public void dragDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
        //accept cookies
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }
    @Test
    public void clickwithJS(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink= driver.findElement(By.linkText("Dropdowm"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", dropdownLink);
    }
    @Test
    public void typewithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputbox= driver.findElement(By.cssSelector("#input-example>input"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        String text="Hello disabled Input";
        jse.executeScript("arguments[0].setAttribute('value','"+ text+"')",inputbox);
    }
    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        //Scroll down
        for (int i=0;i<10;i++){
            Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,250)");
        }

        //Scroll up
        for (int i=0;i<10;i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250)");
        }
    }
    @Test
    public void ScrolltoElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement eng= driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", eng);
    }

}
