package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader2;
import com.cybertek.utilities.ConfigurationReader3;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBaseThree {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().window().maximize();
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);
        driver.get(ConfigurationReader3.get("n11.url"));
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //Driver.closeDriver();
    }
}
