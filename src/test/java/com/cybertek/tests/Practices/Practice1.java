package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice1 {
    public static void main(String[] args) throws InterruptedException {
        /*Test case 1
         Go to Ebay
         enter search term
         click on search button
         print number of results*/
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        WebElement searchBox= driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("wooden spoon");
        WebElement searchButton= driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement textResult= driver.findElement(By.tagName("h1"));
        String result=textResult.getText();
        System.out.println("result = " + result);
        String [] arr=result.split(" ");

        System.out.println("Result= "+arr[0]);

    }
}
