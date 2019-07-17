package com.cybertek.tests.OfficeHour_July8;

import com.cybertek.tests.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGIntro {

    WebDriver driver;
    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Etsy")).click();
        SeleniumUtils.sleep(2);
        String expectedURL = "https://www.etsy.com/";
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
