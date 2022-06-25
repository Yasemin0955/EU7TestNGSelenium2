package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice2 {
    public static void main(String[] args) {
        /*Test case 2
        Go to Ebay
        search Selenium
        click on search button
        verify title contains Selenium*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement searchBox= driver.findElement(By.xpath("//input[@name='_nkw']"));
        searchBox.sendKeys("selenium");
        WebElement searchButton= driver.findElement(By.id("gh-btn"));
        searchButton.click();
        System.out.println("Title contains selenium "+ driver.getTitle().contains("selenium"));
    }
}
