package com.cybertek.tests.Practices.day9HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test8 {
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
    /*Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. And click on “Autocomplete”.
Step 3. Enter “United States of America” into
country input box.
Step 4. Verify that following message is displayed:
“You selected: United States of America*/
    @Test
    public void test8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement autocomplete = driver.findElement(By.linkText("Autocomplete"));
        autocomplete.click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        //verify message is displayed
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed(),"result is not displayed");

    }
}
