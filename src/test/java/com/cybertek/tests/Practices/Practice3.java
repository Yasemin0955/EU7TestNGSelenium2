package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice3 {
    public static void main(String[] args) {
       /* Test case 3
        Go to wikipedia.org (Links to an external site.)
        enter search term `selenium webdriver`
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)'*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        WebElement searchBox=driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("selenium webdriver");
        WebElement searchButton= driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']"));
        searchButton.click();
        WebElement result= driver.findElement(By.xpath("//a[@title='Selenium (software)']"));
        result.click();
        String url=driver.getCurrentUrl();
        System.out.println("Current url ends with Selenium_(software)= "+url.endsWith("Selenium_(software)"));
        driver.quit();
    }
}
