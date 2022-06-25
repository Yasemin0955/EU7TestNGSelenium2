package com.cybertek.tests.reviews.week01;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02_CybertekUrlTask {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        //to maximize the page .sometimes selenium can not find the element without maximizing
        driver.manage().window().maximize();
        String expectedUrlText="cybertekschool";
        String actualUrl=driver.getCurrentUrl();
        System.out.println("Verify if actualurl contains ceybertekschool: "+actualUrl.contains(expectedUrlText));
        System.out.println("verify title: "+driver.getTitle().equalsIgnoreCase("practice"));
    }
}
