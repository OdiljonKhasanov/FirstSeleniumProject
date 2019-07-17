package com.cybertek.tests.Day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationFormTest {

    String departmentLocator = "[name='department']";

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/registration_form");

    }

    @Test
    public void departmentTest1(){
        Select select = new Select(driver.findElement(By.cssSelector(departmentLocator)));
        List<WebElement>options = select.getOptions();
        for(WebElement option: options){
            System.out.println(option.getText());
        }


    }

    @AfterMethod
    public  void tearDown(){
        driver.close();
    }
}
