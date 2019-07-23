package com.cybertek.tests.Day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class LocatorsPracticeTagName {
    static WebDriver driver = BrowserFactory.getDriver("chrome");


    public static void main(String[] args) throws Exception{

        test1();

    }

    public static void test1() throws Exception{
        driver.manage().window().maximize();
        //selenium wait 30 sconds to find element
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //How to fing all buttons?
        //we use findElements
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("Size: " + buttons.size());

        for (WebElement button: buttons){
            System.out.println(button.getText());
            button.click();

            Thread.sleep(1000);
        }

        driver.close();
    }


}
