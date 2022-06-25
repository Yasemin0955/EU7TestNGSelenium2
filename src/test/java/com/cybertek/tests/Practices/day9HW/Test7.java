package com.cybertek.tests.Practices.day9HW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test7 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
       driver.quit();
    }
    @Test
    public void test7(){
        /*Step 1. Go to “https://practicecybertekschool.herokuapp.com”
         Step 2. And click on “File Upload".
         Step 3. Upload any file with .txt extension from your
         computer.
         Step 4. Click “Upload” button.
         Step 5. Verify that subject is: “File Uploaded!”
         Step 6. Verify that uploaded file name is displayed.
         Note: use element.sendKeys(“/file/path”) with
         specifying path to the file for uploading. Run this
         method against “Choose File” button. */
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        WebElement fileUpload= driver.findElement(By.linkText("File Upload"));
        fileUpload.click();
        WebElement chooseFile= driver.findElement(By.name("file"));
        //sending file with sendkeys method with as path
        String projectPath=System.getProperty("user.dir");  //dynamic project path
        String filePath="src/test/resources/textfile.txt";   //static file path
        String fullPath=projectPath+"/"+filePath;
        chooseFile.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();
        //Verify that uploaded file name is displayed.
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();

        Assert.assertEquals(actualFileName,"textfile.txt","file not uploaded");
        //verify that uploaded message is displayed
        WebElement msg = driver.findElement(By.xpath("//h3[.='File Uploaded!']"));
        Assert.assertTrue(msg.isDisplayed(),"Uploaded message is not displayed");

    }

}
