package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TESTNGAssertionDemo {
    @BeforeMethod
    public void setUp(){
        System.out.println("Opening browser");
    }
    @AfterMethod
    public void quit(){
        System.out.println("Closing browser");
    }
    @Test
    public void test1(){
        System.out.println("First assertion");
        Assert.assertEquals("title","title");

        System.out.println("Second assertion");
        Assert.assertEquals("url","url");

    }
    @Test
    public void test2(){
        Assert.assertEquals("test2","test2");
    }
    @Test
    public void test3(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title starts with Cyb");
    }
    @Test
    public void test4(){
        //verify email contains
        String email="mike@smsith.com";
        Assert.assertTrue(email.contains("@"), "Verify email contains @");
    }
    @Test
    public void test5(){
        Assert.assertFalse(0>1,"Verify 0 is not greater than 1");
    }
    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }
}
