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

public class TC05 extends TestBase {
    /*Test Case #5
1. Go to “https://qa1.vytrack.com/"
2. Login as a store manager
3. Navigate to “Activities -> Calendar Events”
4. Click on the top checkbox to select all
5. Verify that all calendar events were selected*/
    @Test
    public void test1(){
        LoginPage loginPage=new LoginPage();
        loginPage.loginAsStoreManager();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        calendarEventsPage.selectAllButton.click();
        List<WebElement> elements = Driver.get().findElements(By.xpath("//input[@tabindex='-1']"));
        for (WebElement element : elements) {
            Assert.assertTrue(element.isSelected(),"Element is not selected");

        }


    }
}
