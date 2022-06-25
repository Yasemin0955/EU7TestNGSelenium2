package com.cybertek.tests.day11_webTables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void PrintTable(){
       WebElement table= driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println(table.getText());
        Assert.assertTrue(table.getText().contains("jdoe@hotmail.com"));
    }
    @Test
    public void getAllHeaders(){
        //how many coloumn we have
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println(headers.size());
        for (WebElement header : headers) {
            System.out.println(header.getText());

        }
    }
    @Test
    public void printTableSize(){
        //number of colomns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());
        //number of rows
        List<WebElement> AllrowswithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(AllrowswithHeader.size());

        //number of rows without header
        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(rowsWithoutHeader.size());


    }
    @Test
    public void getRow() throws InterruptedException {
        //print the second row info
        WebElement row2=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println(row2.getText());


        //get All rows dynamiclly
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i <= numRows.size(); i++) {
            Thread.sleep(2000);
            WebElement row=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(row.getText());

        }


        }
    @Test
    public void GetAllCellInOneRow(){
        List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        for (WebElement webElement : allCellsInOneRow) {
            System.out.println(webElement.getText());
        }
    }
    @Test
    public void getASingleCell(){
        WebElement element = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[2]"));
        System.out.println(element.getText());

    }
    @Test
    public void printAllCellsByIndex(){
        int rowNumbers=getRowNumbers();
        int coloumnNumbers=getColoumnNumbers();
        System.out.println("coloumnNumbers = " + coloumnNumbers);
        System.out.println("rowNumbers = " + rowNumbers);
        for (int i = 1; i <= rowNumbers; i++) {

            for (int j = 1; j <= coloumnNumbers; j++) {
                 String cellXpath="//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);
                WebElement element = driver.findElement(By.xpath(cellXpath));
                System.out.println(element.getText());

            }



        }
    }
    @Test
    public void getCellInRelationToAnotherCellInSameRow(){
        String firstName="Jason";
        String xpath="//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email= driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());

    }

    private int getColoumnNumbers() {
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getRowNumbers() {
        List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return rowsWithoutHeader.size();
    }



}

