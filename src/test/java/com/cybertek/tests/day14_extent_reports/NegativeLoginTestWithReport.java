package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPassword(){
        extentLogger= report.createTest("Wrong Password Test");
        LoginPage loginPage=new LoginPage();
        extentLogger.info("Enter Username:user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter Password:somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();



//        driver.findElement(By.id("prependedInput")).sendKeys("user1");
//        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
//        driver.findElement(By.id("_submit")).click();

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong password test is passed");
    }
    @Test
    public void wrongUsername(){
        extentLogger= report.createTest("Wrong Username Test");
        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter Username:someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter Password:UserUser123");
        loginPage.passwordInput.sendKeys("Useruser123");

        extentLogger.info("Click login button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login234");
    }
}
