package com.cybertek.tests.OfficeHour_July2;

import com.cybertek.tests.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkTextExample {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception{

        //test1();
        test2();
    }

    public static void test1 ()throws Exception{
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
        Thread.sleep(1500);
        driver.close();

    }

    public static void test2()throws Exception{
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
//        for(WebElement link: links){
//            link.click();
//            Thread.sleep(1000);
//            driver.navigate().back();
//
//        }

        for(int i = 1; i< links.size();i++){
            if(i==4 || i== 41){continue;}
            links.get(i).click();
            driver.navigate().back();
            links = driver.findElements(By.tagName("a"));
            System.out.println(links.get(i).getText());
        }
        driver.close();
    }


}
