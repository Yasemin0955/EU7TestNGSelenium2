package com.cybertek.pages.n11Pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePageN11{
//    @FindBy(css = "a[title='Kozmetik & Kişisel Bakım']")
//    public WebElement kozmetikVeKisiselBakimLink;
//
//    @FindBy(css = "a[title='Parfüm & Deodorant']")
//    public WebElement parfumVeDeodorant;

    @FindBy(css = "i[class='icon iconSearchDark']")
    public WebElement brandSearchButton;

    @FindBy(css = ".attributeSearch")
    public WebElement brandInputBox;

//    @FindBy(id = "brand-m-Lacoste")
//    public WebElement lacosteCheckBox;

    @FindBy(css = "div[data-position='7']")
    public WebElement lacosteproduct7;

    public void navigateTo(String mainCategory , String subCategory){
        Driver.get().findElement(By.cssSelector("a[title='"+mainCategory+"']")).click();
        BrowserUtils.waitFor(2);
        //handle html alert
        Driver.get().findElement(By.cssSelector("button[class='dn-slide-accept-btn']")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.cssSelector("a[title='"+subCategory+"']")).click();
    }
    public void selectNthProductFromAbrand(int productNumber,String brand){
        brandSearchButton.click();
        //search for a brand
        brandInputBox.sendKeys(brand);
        //click on the checkbox
        Driver.get().findElement(By.cssSelector("input[data-iv='"+brand+"']")).click();//this is brand checkbox
        //click on a specific element on the result page
        Driver.get().findElement(By.cssSelector("div[data-position='"+productNumber+"']")).click();

    }
}
