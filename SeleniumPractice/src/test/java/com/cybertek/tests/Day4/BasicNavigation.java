package com.cybertek.tests.Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main (String[] args) throws Throwable{



        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.google.com/";

        driver.get(url);
        Thread.sleep(3000);
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);




        //will close web browser
        driver.close();



    }

}
