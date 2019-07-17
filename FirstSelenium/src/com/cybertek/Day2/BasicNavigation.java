package com.cybertek.Day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    //throws Exception means someone else is responsible to handle this exception
    //whoever is calling method
    //it works without try/catch because we can throw exception on the method level declaration
    //tha means we are not responsible for handling this exception any more
    public static void main(String[] args) throws Exception{
        //since we use getDriver() it will set path to the webdriver for us.
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //BasicNavigation is not supposed to be a child class of any class that we wrote before
        //that's why it is not suppose to extend any class
        //Preferable to use BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        Thread.sleep(1000); // wait a second
        driver.get("http://amazon.com");
        Thread.sleep(3000); // wait 3 seconds
        driver.navigate().back();// navigates to the previous url
        //the question is: can we navigate back to the google. com
        //if we opened amazon.com
        //with get() method not navigate().to()
        //as we know, navigate() helps to jump in the browser history
        //in our case is google.com
        Thread.sleep(3000); // wait 3 seconds
        driver.navigate().forward(); // to navigate, to the last website
        Thread.sleep(3000);
        System.out.println("Title: "+driver.getTitle());
        System.out.println("URL: "+driver.getCurrentUrl());
        driver.navigate().refresh(); // to refresh the page
        Thread.sleep(3000);
        driver.close();

    }
}

