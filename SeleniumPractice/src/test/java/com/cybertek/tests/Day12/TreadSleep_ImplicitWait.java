package com.cybertek.tests.Day12;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TreadSleep_ImplicitWait {

    String messageLocator = "#finish";
    String startButtotLocator = "#start>button";


    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.cssSelector(startButtotLocator)).click();
        String expected = "Hello World!";
        String actual = driver.findElement(By.cssSelector(messageLocator)).getText();
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expected = "Hello World!";
        String actual = driver.findElement(By.cssSelector(messageLocator)).getText();
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
