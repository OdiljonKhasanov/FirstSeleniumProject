package com.cybertek.tests.Day5;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Ebay {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("Java Book", Keys.ENTER);
        String result = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(result);
        driver.close();


    }



}
