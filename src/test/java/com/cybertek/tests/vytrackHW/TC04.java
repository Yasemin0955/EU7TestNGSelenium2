package com.cybertek.tests.vytrackHW;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC04 extends TestBase {
    /*Test case #4
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Verify that number of calendar events (rows in
the table) is equals to number of records
Hint: In HTML, <table> tag represents table,
<thread> - table header, <tr> tag represents table
row element, <th> table header cell and <td> table
data.
Css selector: table > tr*/
    @Test
    public void test1() throws InterruptedException {
    LoginPage loginPage=new LoginPage();
    loginPage.loginAsStoreManager();

    DashboardPage dashboardPage=new DashboardPage();
    dashboardPage.navigateToModule("Activities","Calendar Events");



    CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
    Assert.assertEquals(calendarEventsPage.noOfCalendarEvents(),calendarEventsPage.noOfTotalRecordings(),"noOfRows are not equal total number of events");

    }
}
