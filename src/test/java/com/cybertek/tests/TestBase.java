package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
   protected WebDriver driver;
   protected Actions actions;
   protected WebDriverWait wait;
    //This class is used for starting and building report
    protected  ExtentReports report;

    //This class is used to create html report file;
   protected ExtentHtmlReporter htmlReporter;

    //This will define a test, enables adding logs author and test steps
   protected ExtentTest extentLogger;
   @BeforeTest
   public void setUpTest(){
       //initialize the class
       report=new ExtentReports();

       //create a report path
       String projectPath=System.getProperty("user.dir");
       String path=projectPath+"/test-output/report.html";

       //initialize the htmlreporter with the report path
       htmlReporter=new ExtentHtmlReporter(path);

       //attach the html report to report object
       report.attachReporter(htmlReporter);

       //title in report
       htmlReporter.config().setReportName("Vytrack Smoke Test");

       //set environment information
       report.setSystemInfo("Environment","QA");
       report.setSystemInfo("Browser",ConfigurationReader.get("browser"));
       report.setSystemInfo("OS",System.getProperty("os.name") );

   }
    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,10);
        driver.get(ConfigurationReader.get("url"));
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {

       if(result.getStatus()==ITestResult.FAILURE){

           extentLogger.fail(result.getName());

           //take the screenshot and return the location ofn screenshot
           String screenShotPath= BrowserUtils.getScreenshot(result.getName());

           //add your screenshot to the report
           extentLogger.addScreenCaptureFromPath(screenShotPath);

           //capture the exception and put in the report
           extentLogger.fail(result.getThrowable());
       }
        Thread.sleep(3000);
        Driver.closeDriver();
    }
    @AfterTest
    public void tearDownTest(){
        report.flush();
    }
}
