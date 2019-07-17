package com.cybertek.tests.Day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MultipleButtonsTestWithCSSSelector {

    String button1 = "[onclick='button1()']";
    String button2 = ".btn.btn-primary:nth-of-type(2)";
    String button3 = "[id^='button_']"; // means find me element, that has id that starts with "button_" | ^ - starts with
    String button4 = "[id$='_button'][onclick = 'button4()']"; // in this case we specified 2 attributes.| $ - end with
    String button5 = "[onclick*='5']";// means find me element that contains 5 in attribute| *- means contain
    String button6 = "#disappearing_button"; // # - means id

    String result = "#result";

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }


    @Test(priority = 1, description = "Verifying button 1",enabled = true)
    public void button1Test(){
        driver.findElement(By.cssSelector(button1)).click();
        String expectedMessage = "Clicked on button one!";
        String actualMessage = driver.findElement(By.cssSelector(result)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test(priority = 2, dependsOnMethods = {"button1Test"})
    public void button2(){
        driver.findElement(By.cssSelector(button2)).click();
        String expectedMessage = "Clicked on button two!";
        String actualMessage = driver.findElement(By.cssSelector(result)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}
