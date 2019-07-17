package com.cybertek.tests.BriteERP;

import com.sun.tools.classfile.Descriptor;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupProjectTests {

    WebDriver driver;
    String emailBoxLocator = "#login";


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
    }

    @Test (description ="manager should able to search inventory")
    public void SearchInventory(){

        driver.findElement(By.cssSelector(emailBoxLocator)).sendKeys("");
    }

    @AfterMethod
    public void teardown(){

        driver.close();
    }

}
