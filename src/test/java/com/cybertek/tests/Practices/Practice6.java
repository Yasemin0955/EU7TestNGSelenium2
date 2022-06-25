package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice6{
    WebDriver driver;
     @BeforeMethod
    public void setUp(){
      driver= WebDriverFactory.getDriver("chrome");
      driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
         Thread.sleep(2000);
        // driver.quit();
    }
    @Test
    public void Beneficial(){
         driver.get("https://www.reddit.com/");
        WebElement searchButton = driver.findElement(By.id("header-search-bar"));
        searchButton.sendKeys("software testing");
        searchButton.click();
        WebElement element = driver.findElement(By.xpath("//a[@tabindex='-1'][1]"));
        element.click();

    }


}

