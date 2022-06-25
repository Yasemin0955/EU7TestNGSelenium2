package com.cybertek.tests.Practices.day9HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test9_12 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
         driver= WebDriverFactory.getDriver("Chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        WebElement statusCodes= driver.findElement(By.linkText("Status Codes"));
        actions.moveToElement(statusCodes).perform();
        statusCodes.click();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @DataProvider
    public Object[][] statusCodeData(){
        String[][] data={{"200"},{"301"},{"404"},{"500"}};
        return data;
    }

    @Test(dataProvider = "statusCodeData")
    public void testFrom9to12(String value){
         driver.findElement(By.linkText(value)).click();
         WebElement textLines = driver.findElement(By.xpath("//p"));
         String[] Text= textLines.getText().split("\n");
         String actualText=Text[0];
         String expectedText="This page returned a "+value+" status code.";
        Assert.assertEquals(actualText,expectedText,"Verify that text is not expected");

    }
}
