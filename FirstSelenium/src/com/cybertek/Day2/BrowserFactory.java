package com.cybertek.Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    //it's not main method
    //it's a method that returns object of webdriver
    //it can be firefox of chrome based on value of parameter
    public static WebDriver getDriver(String browser){

        if(browser.equals("chrome")){ //we need to specify properties for chromedriver
            //otherwise, selenium will not know where to find chromedriver
            //1st param is webdriver type
            //2nd param is for path to the wedriver
            //it's required by selenium webdriver to interact with web browser
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Odiljon\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        }else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Odiljon\\Documents\\selenium dependencies\\drivers\\geckodriver.exe");
            return new FirefoxDriver();
        }
        return null;



    }

}
