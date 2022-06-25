package com.cybertek.tests.day3_WebElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeOfToday {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.facebook.com/");
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("ercan_macit@hotmail.com");
        WebElement password=driver.findElement(By.id("pass"));
        password.sendKeys("samay0955");
        WebElement loginButton=driver.findElement(By.id("u_0_d_av"));
        Thread.sleep(3000);
        loginButton.click();

    }
}
