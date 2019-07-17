package com.cybertek.Office_Hours;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Factory {

    public static WebDriver getDriver(String browser){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Odiljon\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        }else if (browser.equals("firefox")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Odiljon\\Documents\\selenium dependencies\\drivers\\geckodriver.exe");
            return new FirefoxDriver();
        }else{
            return null;
        }
    }

}
