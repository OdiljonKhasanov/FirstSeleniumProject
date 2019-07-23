package com.cybertek.tests.Day6;

import com.cybertek.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WarmUp {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        //test1();
        test2();
    }

    //    TEST 1
//    go to amazon
//    enter any search term
//    click on search button
//    verify title contains search term
    public static void test1() throws Exception {
        driver.manage().window().maximize();
        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Book");
        driver.findElement(By.className("nav-input")).click();
        String title = driver.getTitle();

        if (title.contains("Book")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.close();
    }
    public static void test2() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        if (url.endsWith(")")) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
        driver.close();

    }

}
