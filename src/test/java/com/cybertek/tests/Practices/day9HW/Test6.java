package com.cybertek.tests.Practices.day9HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test6 {
    /*Step 1. Go to "https://www.tempmailaddress.com/"
Step 2. Copy and save email as a string.
Step 3. Then go to “https://practicecybertekschool.herokuapp.com”
Step 4. And click on “Sign Up For Mailing List".
Step 5. Enter any valid name.
Step 6. Enter email from the Step 2.
Step 7. Click Sign Up
Step 8. Verify that following message is displayed:
“Thank you for signing up. Click the button below to
return to the home page.”
Step 9. Navigate back to the “https://
www.tempmailaddress.com/”
Step 10. Verify that you’ve received an email from
“do-not-reply@practice.cybertekschool.com”
Step 11. Click on that email to open it.
Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
Step 13. Verify that subject is: “Thanks for
subscribing to practice.cybertekschool.com!*/
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test
    public void Test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String email=driver.findElement(By.xpath("//span[@id='email']/..")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
        driver.findElement(By.name("full_name")).sendKeys("Yasemin");
        driver.findElement(By.name("email")).sendKeys(email);
        WebElement SignupInputbox= driver.findElement(By.name("wooden_spoon"));
        SignupInputbox.click();

        //verify that signup message is displayed

        WebElement signup_message = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(signup_message.isDisplayed(),"sign up message is not displayed");
        driver.get("https://www.tempmailaddress.com/");

        //Verify that you’ve received an email from
        //“do-not-reply@practice.cybertekschool.com”

        WebElement emailvisible = driver.findElement(By.xpath("(//span[@class='odMobil'])[1]"));
        Thread.sleep(2000);
        Assert.assertTrue(emailvisible.getText().contains("do-not-reply@practice.cybertekschool.com"),"email is visible on the page");

        emailvisible.click();

        //Verify that email is from: “do-notreply@practice.cybertekschool.com”
        WebElement emailFrom=driver.findElement(By.id("odesilatel"));
        Assert.assertEquals(emailFrom.getText(),"do-not-reply@practice.cybertekschool.com");

        //Verify that subject is: “Thanks for
        //subscribing to practice.cybertekschool.com!*/
        WebElement lastMessg = driver.findElement(By.id("predmet"));
        Assert.assertTrue(lastMessg.isDisplayed(),"Message is not displayed");


    }
}
