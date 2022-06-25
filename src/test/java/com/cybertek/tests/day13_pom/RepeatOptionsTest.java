package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {
   @Test
    public void test1(){
       LoginPage loginPage=new LoginPage();
       loginPage.loginAsDriver();
       DashboardPage dashboardPage=new DashboardPage();
       dashboardPage.navigateToModule("Activities","Calendar Events");

      CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
      calendarEventsPage.waitUntilLoaderScreenDisappear();
      BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,6);
      calendarEventsPage.createCalendarEvent.click();
       CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
       createCalendarEventsPage.repeat.click();
       Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"days is not selected");
       Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"days is  selected");
   }
   @Test
    public void test2(){
       LoginPage loginPage=new LoginPage();
       loginPage.loginAsDriver();
       DashboardPage dashboardPage=new DashboardPage();
       dashboardPage.navigateToModule("Activities","Calendar Events");

       CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
       calendarEventsPage.waitUntilLoaderScreenDisappear();
       BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,7);
       calendarEventsPage.createCalendarEvent.click();
       CreateCalendarEventsPage createCalendarEventsPage=new CreateCalendarEventsPage();
       createCalendarEventsPage.repeat.click();
       Select repeatsDropdown=createCalendarEventsPage.repeatOptionsList();

       List<String> expectedList= Arrays.asList("Daily","Weekly","Monthly","Yearly");
//       List<String> actualList=new ArrayList<>();
//
       List<WebElement> actualOptions=repeatsDropdown.getOptions();
//       for (WebElement Option : actualOptions) {
//          actualList.add(Option.getText());
//
//       }
       List<String> actualList=BrowserUtils.getElementsText(actualOptions);
       Assert.assertEquals(actualList,expectedList,"Daily, weekly,monthly,yearly is not displayed");



   }
}
