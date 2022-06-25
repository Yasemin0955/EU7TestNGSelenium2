package com.cybertek.tests.practice;

import com.cybertek.pages.n11Pages.MainPage;
import com.cybertek.tests.TestBaseThree;
import org.testng.annotations.Test;

public class Task2 extends TestBaseThree {
    /*Navigate to https://www.n11.com/
● Navigate to Perfume & Deodorant under the Cosmetic & Personal Care tab. (Do not
use URL navigation)(Kozmetik & Kişisel Bakım/Parfüm & Deodorant)
● Search for ‘Lacoste’ in Brand filter
● Select ‘Lacoste’
● Click 7th product on the search result page
● Add product to the ‘Favorites’ (Favorilerim)
● Navigate to Favorites (Favorilerim)
● Verify the product title is the same as with the product details page*/

    @Test
    public void task1(){
        MainPage mainPage=new MainPage();
        mainPage.navigateTo("Kozmetik & Kişisel Bakım","Parfüm & Deodorant");
        mainPage.selectNthProductFromAbrand(7,"Lacoste");




    }

}
