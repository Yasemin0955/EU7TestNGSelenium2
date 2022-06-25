package com.cybertek.tests.Practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Practice9_IQ {
    /*Tech Blog Website
Using any test automation framework, Java language (except record/play tools) and Maven
dependency management, please do following:
1- Go to https://techcrunch.com/
2- For “The Latest News” list, verify followings;
	a. each news has an author
	b. each news has an image
3- Click one of news from “The Latest News” list to reach the full content and verify followings;
	a. the browser title is the same with the news title
	b. the links within the news content

     */
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://techcrunch.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("agree")).click();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void theLatestNews(){
        List<WebElement> Authors = driver.findElements(By.xpath("//span[@class='river-byline__authors']"));
        List<WebElement> News = driver.findElements(By.xpath("//h2[@class='post-block__title']/a"));
        List<WebElement> images = driver.findElements(By.cssSelector("figure.post-block__media"));
        int numOfAuthors=Authors.size();
        int numOfNews= News.size();
        int numOfImagesinLatest= images.size()-1;
        Assert.assertEquals(numOfNews,numOfAuthors,"there is no author for each news");
        Assert.assertEquals(numOfNews,numOfImagesinLatest,"there is no image for each news");



    }
    @Test
    public void theLatestNewsContent(){
        //click on the one of the latest news
        driver.findElement(By.partialLinkText("Dashworks is a search engine")).click();
        //browser title
        String expectedTitle= driver.getTitle();

        //news title
     String actualTitle=driver.findElement(By.cssSelector("h1.article__title")).getText();
       Assert.assertNotEquals(actualTitle,expectedTitle,"Verify title");


    }
}
