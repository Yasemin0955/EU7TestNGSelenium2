package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsandAlerts {
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
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //click destroy the world button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h1")).click();

        //CLICK delete BUTTON
        driver.findElement(By.xpath("//span[.='Delete']")).click();
    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
     Thread.sleep(3000);
        //click Click for JS alert button
        driver.findElement(By.xpath("//button[1]")).click();
        //switch to JS alert pop up
        Alert alert =driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //click for JS confirm
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();


        //click for JS prompt
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("MikeSmith");

    }
}
