package com.cybertek.tests.day2_Webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleandURL {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        //to get the title with selenium

        String title = driver.getTitle();
        System.out.println("title = " + title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //String pageSource = driver.getPageSource();
        //System.out.println("pageSource = " + pageSource);
    }
}
