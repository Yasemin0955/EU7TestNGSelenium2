package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice5 {
    /*
 5. Close browser.

    Now is the time to automate a consolidated and final assignment.

3. Test Case - Open Godaddy.com and Validate Page Title
    Steps to Automate:
            1. Launch browser of your choice say., Firefox, chrome etc.
            2. Open this URL - https://www.godaddy.com/
            3. Maximize or set size of browser window.
4. Get Title of page and validate it with expected value.
            5. Get URL of current page and validate it with expected value.
6. Get Page source of web page.
            7. And Validate that page title is present in page source.
            8. Close browser.*/
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
      driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();

    }
   @Test
    public void TC1() throws InterruptedException {


      
    }

    @Test
    public void TC2() throws InterruptedException {
        String actualtitle= driver.getTitle();
        System.out.println("title = " + actualtitle);
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy UK";
        Assert.assertTrue(actualtitle.equals(expectedTitle),"expected actual esit degil");




        String actualcurrentUrl=driver.getCurrentUrl();
        System.out.println("currentUrl = " + actualcurrentUrl);
        String expectedUrl= "https://www.godaddy.com/en-uk";
        Assert.assertTrue(actualcurrentUrl.equals(expectedUrl),"esit degil");

        String code=driver.getPageSource();
        System.out.println("code = " + code);
        Assert.assertTrue(code.contains("Domain Names, Websites, Hosting &amp; Online Marketing Tools - GoDaddy UK"),"icermiyor");


    }
    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
