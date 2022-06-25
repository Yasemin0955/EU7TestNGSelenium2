package com.cybertek.tests.vytrackHW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {
    /*Test case #2
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that page number is equals to "1"

*/
    @Test
    public void tc002(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        Assert.assertEquals(calendarEventsPage.pageNumber(),1,"page number is not 1");
    }
}
