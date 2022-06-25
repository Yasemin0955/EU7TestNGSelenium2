package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxHW {
    @Test
    public void test() throws InterruptedException {
        /**/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();
        WebElement usernameInput= driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        usernameInput.sendKeys("Tester");
        WebElement password= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement loginButton=driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        WebElement checkAll= driver.findElement(By.cssSelector("#ctl00_MainContent_btnCheckAll"));
        checkAll.click();
       //Verify all boxes checked
        WebElement check1= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        WebElement check2= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        WebElement check3= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl04_OrderSelector"));
        WebElement check4= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        WebElement check5= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
        WebElement check6= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        WebElement check7= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl08_OrderSelector"));
        WebElement check8= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector"));


        Assert.assertTrue(check1.isSelected());
        Assert.assertTrue(check2.isSelected());
        Assert.assertTrue(check3.isSelected());
        Assert.assertTrue(check4.isSelected());
        Assert.assertTrue(check5.isSelected());
        Assert.assertTrue(check6.isSelected());
        Assert.assertTrue(check7.isSelected());
        Assert.assertTrue(check8.isSelected());



        WebElement uncheckAll= driver.findElement(By.xpath("//a[text()='Uncheck All']"));
        uncheckAll.click();
        //Verify all boxes are unchecked
        WebElement check11= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        WebElement check22= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector"));
        WebElement check33= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl04_OrderSelector"));
        WebElement check44= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        WebElement check55= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl06_OrderSelector"));
        WebElement check66= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl07_OrderSelector"));
        WebElement check77= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl08_OrderSelector"));
        WebElement check88= driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector"));


        Assert.assertFalse(check11.isSelected(),"verify checkbox1 is not selected");
         Assert.assertFalse(check22.isSelected(),"verify checkbox2 is not selected");
         Assert.assertFalse(check33.isSelected(),"verify checkbox3 is not selected");
         Assert.assertFalse(check44.isSelected(),"verify checkbox4 is not selected");
         Assert.assertFalse(check55.isSelected(),"verify checkbox5 is not selected");
         Assert.assertFalse(check66.isSelected(),"verify checkbox6 is not selected");
         Assert.assertFalse(check77.isSelected(),"verify checkbox7 is not selected");
         Assert.assertFalse(check88.isSelected(),"verify checkbox8 is not selected");



        Thread.sleep(3000);

        WebElement checkBox= driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
        checkBox.click();
        WebElement deleteSelected= driver.findElement(By.cssSelector("#ctl00_MainContent_btnDelete"));
        deleteSelected.click();

        //Verify that deleted is no longer existed
        WebElement name= driver.findElement(By.xpath("//td[text()='Mark Smith']"));
        Assert.assertFalse(name.getAttribute("innerHTML").equals("Paul Brown"),"verify Paul Brown is no longer exist");



        Thread.sleep(3000);
        driver.quit();
    }
}
