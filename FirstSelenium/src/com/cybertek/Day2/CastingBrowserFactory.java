package com.cybertek.Day2;

import org.openqa.selenium.WebDriver;

public class CastingBrowserFactory {
    public static void main(String[] args) {
        //        WebDriver driver = new ChromeDriver();
        //getDriver is a static method
        //so we don't need to create an object
        //to use that method
        //in order to call static members
        //we use classname not object name

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();// command to maximize browser
        driver.get("http://practice.cybertekschool.com");

        try {//sleep method throws checked exception
            //that means we have to handle it
            //unchecked exceptions occurs during runtime
            Thread.sleep(3000);// this command will stop execution for 3 seconds
        } catch (InterruptedException e) {
            e.getMessage();
        }
        //this is out test
        //we are checking if expected title is the same as actual
        String actualTitle = driver.getTitle();
        String expected = "Practice$";
        if(actualTitle.equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected title: " + expected);
            System.out.println("Actual title: " + actualTitle);
        }


        driver.close();// close browser at the end of test

    }
}
