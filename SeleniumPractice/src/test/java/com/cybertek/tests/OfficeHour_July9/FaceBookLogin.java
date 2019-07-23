package com.cybertek.tests.OfficeHour_July9;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookLogin {

    public static void main(String[] args) {

    }

    public static void test1(){

        WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        SeleniumUtils.waitPlease(3);


    }
}
