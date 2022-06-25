package com.cybertek.tests.vytrackHW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.CacheRequest;

public class TC06 extends TestBase {
    /*Test Case #6
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Select “Testers meeting”
5. Verify that following data is displayed:*/
    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.testersMeeting.click();
        Assert.assertTrue(calendarEventsPage.testersmeetingContent.isDisplayed(),"Content is not displayed");

    }
}
