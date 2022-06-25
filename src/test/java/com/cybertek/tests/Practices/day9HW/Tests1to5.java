package com.cybertek.tests.Practices.day9HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests1to5 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://practice-cybertekschool.herokuapp.com/");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
    driver.quit();
    }
    @Test
    public void test1(){
        /*Step 1. Go to “https://practicecybertekschool.herokuapp.com”
         Step 2. Click on “Registration Form”
         Step 3. Enter “wrong_dob” into date of birth input
         box.
         Step 4. Verify that warning message is displayed:
         “The date of birth is not valid”*/
        WebElement registrationForm= driver.findElement(By.linkText("Registration Form"));
        registrationForm.click();
        WebElement dob= driver.findElement(By.name("birthday"));
        dob.sendKeys("1234456");
        WebElement invalidInput= driver.findElement(By.xpath("//small[@data-bv-for='birthday'][2]"));
        Assert.assertTrue(invalidInput.isDisplayed(),"invalid message is not displayed");
    }
    @Test
    public void test2(){
        /*Step 1. Go to “https://practicecybertekschool.herokuapp.com”
         Step 2. Click on “Registration Form”
         Step 3. Verify that following options for
         programming languages are displayed: c++, java,
         JavaScript*/
        WebElement registrationForm= driver.findElement(By.linkText("Registration Form"));
        registrationForm.click();

        //locate lang text is visible
        WebElement languages= driver.findElement(By.xpath("//label[text()='Select programming languages']"));

        //locate list of languages by using regular locator
        List<WebElement> langelements = driver.findElements(By.className("form-check-label"));

        //by using size make sure that elements are located if it is 0 it means wrong locator
        System.out.println("langelements.size() = " + langelements.size()); //3

        //via for each loop get the text of the languages and verify they are displayed
        for (WebElement langelement : langelements) {
            System.out.println(langelement.getText());
            Assert.assertTrue(langelement.isDisplayed(),"Each languages are not displayed");

        }

    }
    @Test
    public void test3(){
        /*Step 1. Go to “https://practicecybertekschool.herokuapp.com”
          Step 2. Click on “Registration Form”
          Step 3. Enter only one alphabetic character into first
          name input box.
          Step 4. Verify that warning message is displayed:
          “first name must be more than 2 and less than 64
          characters long”*/
        WebElement registrationForm= driver.findElement(By.linkText("Registration Form"));
        registrationForm.click();
        WebElement firstnameInput= driver.findElement(By.name("firstname"));
        firstnameInput.sendKeys("a");
        WebElement invalidName= driver.findElement(By.xpath("//small[@data-bv-for='firstname'][2]"));
        Assert.assertTrue(invalidName.isDisplayed(),"Invalid firstname message is not displayed");
    }
    @Test
    public void test4(){
        /*Step 1. Go to https://practicecybertekschool.herokuapp.com
          Step 2. Click on “Registration Form”
          Step 3. Enter only one alphabetic character into last
          name input box.
          Step 4. Verify that warning message is displayed:
          “The last name must be more than 2 and less than
           64 characters long*/
        WebElement registrationForm= driver.findElement(By.linkText("Registration Form"));
        registrationForm.click();

        WebElement lastnameInput= driver.findElement(By.name("lastname"));
        lastnameInput.sendKeys("f");
        WebElement invalidlastName= driver.findElement(By.xpath("//small[@data-bv-for='lastname'][2]"));
        Assert.assertTrue(invalidlastName.isDisplayed(),"Invalid lastname message is not displayed");
    }
    @Test
    public void test5(){
        /*Step 1. Go to “https://practicecybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter any valid first name.
Step 4. Enter any valid last name.
Step 5. Enter any valid user name.
Step 6. Enter any valid password.
Step 7. Enter any valid phone number.
Step 8. Select gender.
Step 9. Enter any valid date of birth.
Step 10. Select any department.
Step 11. Enter any job title.
Step 12. Select java as a programming language.
Step 13. Click Sign up.
Step 14. Verify that following success message is
displayed: “You've successfully completed
registration!*/
        WebElement registrationForm= driver.findElement(By.linkText("Registration Form"));
        registrationForm.click();
        WebElement firstnameInput= driver.findElement(By.name("firstname"));
        firstnameInput.sendKeys("Yasemin");

        WebElement lastnameInput= driver.findElement(By.name("lastname"));
        lastnameInput.sendKeys("Macit");

        WebElement usernameInput= driver.findElement(By.name("username"));
        usernameInput.sendKeys("yasemin");

        WebElement emailInput= driver.findElement(By.xpath("//input[@data-bv-field='email']"));
        emailInput.sendKeys("ymacit@gmail.com");

        WebElement passwordInput= driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("abc12345");

        WebElement phonenumberInput= driver.findElement(By.name("phone"));
        phonenumberInput.sendKeys("123-545-9000");

        WebElement gender=driver.findElement(By.xpath("//input[@value='female']"));
        gender.click();

        WebElement dob= driver.findElement(By.name("birthday"));
        dob.sendKeys("10/08/1991");

      WebElement departmentDropdown= driver.findElement(By.name("department"));
        Select departments=new Select(departmentDropdown);
        departments.selectByIndex(2);

        WebElement jobTitle=driver.findElement(By.name("job_title"));
        Select jobTitles=new Select(jobTitle);
        jobTitles.selectByIndex(4);

        WebElement lang=driver.findElement(By.id("inlineCheckbox2"));
        lang.click();

        WebElement signupButton=driver.findElement(By.id("wooden_spoon"));
        signupButton.click();

        WebElement finalmessage=driver.findElement(By.xpath("//h4/following-sibling::p"));
        Assert.assertTrue(finalmessage.isDisplayed());


    }

}
