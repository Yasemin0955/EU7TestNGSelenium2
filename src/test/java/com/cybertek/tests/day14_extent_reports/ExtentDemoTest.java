package com.cybertek.tests.day14_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentDemoTest{
   //This class is used for starting and building report
   ExtentReports report;

   //This class is used to create html report file;
   ExtentHtmlReporter htmlReporter;

   //This will define a test, enables adding logs author and test steps
   ExtentTest extentLogger;

   @BeforeMethod
   public void setUp(){
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
   @Test
   public void test1(){
      //give name to the current test
      extentLogger=report.createTest("Login as Driver Test123");

      //test steps
      extentLogger.info("Open Chrome browser");
      extentLogger.info("Go to this URL");
      extentLogger.info("Enter driver username password");
      extentLogger.info("verify logged in");

      //pass() marks
      extentLogger.pass("Test123 passed");
   }
   @AfterMethod
   public void tearDown(){
      //
      report.flush();
   }

}
