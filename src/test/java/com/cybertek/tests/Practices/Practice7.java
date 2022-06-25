package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Practice7 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        /*Customer navigation through product categories: Phones, Laptops and Monitors
•        Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.*/
        driver.get("https://www.demoblaze.com/index.html");
        WebElement Laptops = driver.findElement(By.id("itemc"));
        Laptops.click();
        WebElement sony_vaio_i5 = driver.findElement(By.linkText("Sony vaio i5"));
        sony_vaio_i5.click();
        WebElement add_to_cart = driver.findElement(By.linkText("Add to cart"));
        add_to_cart.click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert =driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        // Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
        Thread.sleep(3000);
        driver.navigate().back();
        driver.navigate().back();

       WebElement Laptops1 = driver.findElement(By.xpath("//a[@id='itemc'][2]"));
        Laptops1.click();
        WebElement Delli7 = driver.findElement(By.linkText("Dell i7 8gb"));
        Delli7.click();
        WebElement add_to_cart1 = driver.findElement(By.xpath("//a[@onclick='addToCart(12)']"));
        add_to_cart1.click();

        wait.until(ExpectedConditions.alertIsPresent());
        alert =driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
        WebElement cart = driver.findElement(By.id("cartur"));
        cart.click();
        WebElement deleteButton = driver.findElement(By.xpath("(//td)[4]/a"));
        deleteButton.click();

        //Click on "Place order".
        WebElement placeOrder = driver.findElement(By.xpath("//button[@data-toggle='modal']"));
        placeOrder.click();



        //Fill in all web form fields.
        WebElement name = driver.findElement(By.id("name"));

        name.sendKeys("yasemin");
        driver.findElement(By.id("country")).sendKeys("turkey");
        driver.findElement(By.id("city")).sendKeys("aydin");
        driver.findElement(By.id("card")).sendKeys("1223345678");
        driver.findElement(By.id("month")).sendKeys("February");
        driver.findElement(By.id("year")).sendKeys("2017");

        // Click on "Purchase"
        WebElement purchaseButton = driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']"));
        purchaseButton.click();


    }
}
