package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {

       // System.setProperty("webdriver.chrome.driver","C:\\Users\\Odiljon\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

        System.setProperty("webdriver.gecko.driver","C:\\Users\\Odiljon\\Documents\\selenium dependencies\\drivers\\geckodriver.exe");

        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");


    }
}
