package com.cybertek.tests.day3_WebElement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) throws InterruptedException {
        /*
    Verify confirmation message
        open chrome browser
        go to http://practice.cybertekschool.com/forgot_password Links to an external site.
        enter any email
        verify that email is displayed in the input box
        click on Retrieve password
        verify that confirmation message says 'Your e-mail's been sent!'
     */

        //open chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox=driver.findElement(By.name("email"));

        String expectedEmail="ymacit@gmail.com";
        emailInputBox.sendKeys(expectedEmail);

        //somehow we should get text from web elements
        //two main ways to get txt from web elements
        //1.getText()--> it will work %99 and it will return string
        //2.getAttribute("value") --> second way of getting text especially input boxes



        String actualEmail=emailInputBox.getAttribute("value");
        System.out.println("Actual email: "+actualEmail);
        if (expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        WebElement retrievepasswordButton=driver.findElement(By.id("form_submit"));
        retrievepasswordButton.click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualconfirmationMessage=driver.findElement(By.name("confirmation_message"));
        System.out.println(actualconfirmationMessage.getText());

        String expectedmessage="Your e-mail's been sent!";
        String actualmessage = actualconfirmationMessage.getText();
        if(expectedmessage.equals(actualmessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
