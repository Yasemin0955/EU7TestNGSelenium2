package com.cybertek.pages.n11Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePageN11{
    @FindBy(linkText = "https://www.n11.com/giris-yap")
    public WebElement loginLink;

}
