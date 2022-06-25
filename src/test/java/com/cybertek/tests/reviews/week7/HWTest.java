package com.cybertek.tests.reviews.week7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HWTest extends TestBaseForHW{
    @Test
    public void verifyOptions(){
        extentLogger= report.createTest("Verify Options Link");
        extentLogger = report.createTest("Verify Options Link");
        extentLogger.info("Preconditions Loaded");
        extentLogger.info("Verify that Options Link is Displayed");
        Assert.assertTrue(page.options.isDisplayed(),"options not displayed");
        extentLogger.pass("Options is Displayed");

    }
    @Test
    public void verifyPageNumber(){
        extentLogger= report.createTest("Verify Page Number");
        extentLogger.info("verify page number");
        Assert.assertEquals(page.pageNumber(),1,"Page number is not 1");
        extentLogger.pass("Page number is verified");
    }
    @Test
    public void verifyViewPerPage(){
        extentLogger= report.createTest("Verify View Per Page");
        extentLogger.info("Verify View Per Page");
        Assert.assertEquals(page.viewPerPageValue(),25,"View per page is not 25");
        extentLogger.pass("Test Passed");
    }
}
