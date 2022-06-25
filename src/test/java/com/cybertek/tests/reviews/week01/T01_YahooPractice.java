package com.cybertek.tests.reviews.week01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_YahooPractice {
    public static void main(String[] args) {
      //  WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://uk.yahoo.com/?p=us");
        String expectedTitle="Yahoo";
        String actualTitle=driver.getTitle();
        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

    }
}
