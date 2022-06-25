package com.cybertek.pages.n11Pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageN11 {
    public BasePageN11() {
        PageFactory.initElements(Driver.get(), this);
    }
}
