package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {
    @DataProvider
    public Object[][] testData(){
        ExcelUtil qa3short=new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        String [][] dataArray= qa3short.getDataArrayWithoutFirstRow();
        return dataArray;
    }
    @Test(dataProvider = "testData")
    public void test1(String username,String password,String firstname,String lastname){
        extentLogger= report.createTest("Test"+firstname+" "+lastname);
        LoginPage loginPage=new LoginPage();
        BrowserUtils.waitFor(2);
        loginPage.login(username,password);

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        String actualFullName=dashboardPage.getUserName();
        String expectedFullName=firstname+" "+lastname;
        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        extentLogger.pass("Passed");

    }
}
