package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Practice4 {
    @Test
    public void test() throws InterruptedException {
        /*
1. Open Chrome browser

2. Go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.

3. Locate all the WebElements on the page using XPATH locator only (total of 6)

   a. “Home” link

   b. “Forgot password” header

   c. “E-mail” text

   d. E-mail input box

   e. “Retrieve password” button



4.Print text of a,b,c,e and put some email to d */
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        WebElement home= driver.findElement(By.xpath("//a[@href='/']"));
        System.out.println("Text is = " + home.getText());
        WebElement forgotpassword= driver.findElement(By.xpath("//h2"));
        System.out.println("forgotpassword.getText() = " + forgotpassword.getText());
        WebElement emailText= driver.findElement(By.xpath("//label[text()='E-mail']"));
        System.out.println("emailText.getText() = " + emailText.getText());
        WebElement mailInput= driver.findElement(By.xpath("//input[@name='email']"));
       // mailInput.sendKeys("mike@smith.com");
        Thread.sleep(2000);
        mailInput.sendKeys("ymacit@gmail.com");
        WebElement retrieveButton= driver.findElement(By.xpath("//button[@id='form_submit']"));
        System.out.println("retrieveButton.getText() = " + retrieveButton.getText());
        retrieveButton.click();
        driver.quit();
    }
}
