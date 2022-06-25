package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Pratice8_interviewQ {
    /*v.Test application www.IonicPartners.com:
vi. Test 1: Go to <Blog> page and scroll it down
vii. Test 2: Go to <About> page, scroll it down and click on Twitter icon at the bottom of the page*/
    @Test
    public void test1() throws InterruptedException {
    WebDriver driver= WebDriverFactory.getDriver("chrome");
    driver.get("https://www.ionicpartners.com/");
    driver.manage().window().maximize();
        WebElement blog = driver.findElement(By.cssSelector("#slider-11-slide-51-layer-148"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", blog);
        js.executeScript("window.scroll(0,document.body.scrollHeight)");

        driver.navigate().back();
        Thread.sleep(2000);
        WebElement aboutUs = driver.findElement(By.xpath("//a[@data-color='#ffffff']"));
        js.executeScript("arguments[0].click();", aboutUs);
        js.executeScript("window.scroll(0,document.body.scrollHeight)");

        WebElement twitter = driver.findElement(By.xpath("//i[@class='fa fa-twitter']"));
        twitter.click();
        driver.quit();


    }

}
