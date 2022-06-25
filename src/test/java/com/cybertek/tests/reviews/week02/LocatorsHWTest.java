package com.cybertek.tests.reviews.week02;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorsHWTest {
    /*Test case
            Go to Ebay
            search Selenium
            click on search button
            print number of results
            verify title contains Selenium
    */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        //1 locator id
        //WebElement searchBox= driver.findElement(By.id("gh-ac"));//to duplicate it CTRL+D
        //2 locator name
        WebElement searchBox= driver.findElement(By.name("_nkw"));
         //locator className
        // WebElement searchBox= driver.findElement(By.className("gh-tb ui-autocomplete-input"));
        // if there is space in the value of class name it will throw exception error no such element
        //  for tagName  //input tag for search box reveals 7 items and my element is the 3rd one so we
        // cannot use it for this element

        String expectedSrearchItem="selenium";
        searchBox.sendKeys(expectedSrearchItem);
        Thread.sleep(3000);
        WebElement searchButton=driver.findElement(By.id("gh-btn"));
        searchButton.click();
        Thread.sleep(3000);

        WebElement searchResultElement= driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));

        String searchResultText = searchResultElement.getText();

        String [] arr = searchResultText.split(" ");

        System.out.println("Number os search results = " + arr[0]);


    }
}
