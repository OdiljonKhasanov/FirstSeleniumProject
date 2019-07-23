package com.cybertek.tests.cybertekschool;

import com.cybertek.utilities.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class loginLogout {



    public static void main(String[] args) {



        //System.setProperty("webdriver.chromedriver.driver","C:\Users\Odiljon\Documents\selenium dependencies\drivers\chromedriver.exe")
        WebDriverManager.chromedriver().setup();


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        //library.sleep(2);

        driver.get("http://practice.cybertekschool.com/login");
        library.sleep(2);

        driver.findElement(By.name("username")).sendKeys("tomsmith##");
        library.sleep(2);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        library.sleep(2);

        driver.findElement(By.id("wooden_spoon")).click();
        library.sleep(3);

        String expectedURL = "http://practice.cybertekschool.com/secure";
        String actualURL = driver.getCurrentUrl();

        //driver.findElement(By.class("flash success"));


        if(expectedURL.equals(actualURL)){
            System.out.println("Login was successifull ");
        }else {
            System.out.println("Login was NOT successifull");
            System.out.println("Test failed");
        }

//        driver.findElement(By.className("icon-2x icon-signout")).click();
//        library.sleep(2);


       driver.quit();

    }
}
