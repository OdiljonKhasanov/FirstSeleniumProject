package com.cybertek.tests.Day13;

import com.cybertek.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorTests {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void jsExecutorTest1(){
        driver.get("http://practice.cybertekschool.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String title = (String)js.executeScript("return document.title");
        js.executeAsyncScript("alert('Hello Odiljon!!!')");
        SeleniumUtils.waitPlease(3);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        SeleniumUtils.waitPlease(3);
        System.out.println(title);
    }

    @Test
    public void scrollTest1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0; i< 11; i++) {
            js.executeScript("window.scrollBy(0, 250)");
            SeleniumUtils.waitPlease(1);
        }
    }


    @Test
    public void scrollTest2(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement footLink = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", footLink);
        SeleniumUtils.waitPlease(2);
        js.executeScript("arguments[0].click()", footLink);
        SeleniumUtils.waitPlease(2);

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
