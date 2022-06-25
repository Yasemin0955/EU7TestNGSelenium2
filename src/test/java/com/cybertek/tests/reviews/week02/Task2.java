package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        /*go to https://www.demoblaze.com/index.html#
    Navigate to Laptops Category
    Then Sony vaio i7 laptop
    Verify the product price is 790 Dollars
         */
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        WebElement laptopscategory= driver.findElement(By.linkText("Laptops"));
        laptopscategory.click();
        Thread.sleep(2000);
        WebElement findSony= driver.findElement(By.linkText("Sony vaio i7"));
        findSony.click();
        Thread.sleep(3000);
        int expectedResult=790;

        WebElement priceTextElement=driver.findElement(By.tagName("h3"));
        String priceText = priceTextElement.getText();

        System.out.println("Price Text "+ priceText);
        String [] arr=priceText.split(" ");
        int actualResult=Integer.parseInt(arr[0].substring(1));
        System.out.println("Expected and actual result is same "+(expectedResult==actualResult));

    }
}
