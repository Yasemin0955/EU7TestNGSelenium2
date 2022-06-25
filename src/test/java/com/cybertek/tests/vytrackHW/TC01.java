package com.cybertek.tests.vytrackHW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {
    @Test
    public void tc01(){
        /*Test case #1
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page subtitle "Options" is displayed*/

        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");


        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.options.isDisplayed(),"Options are not displayed");


    }
}
