package com.cybertek.tests.Day4;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public static void main(String[] args) throws Exception {
        //this line replaces System.setProperty("webdriver", "pah to the webdriver")
        WebDriverManager.chromedriver().setup(); //setup webdriver
        //driver will give us access to the browser
        WebDriver driver = new ChromeDriver(); // create object of chrome driver
        driver.manage().window().maximize(); // open browser maximized
        driver.get("http://practice.cybertekschool.com/forgot_password"); // open url

        WebElement emailInputBox = driver.findElement(By.name("email")); //we found input box
        WebElement submitButton = driver.findElement(By.id("form_submit"));//we found submit button

        Faker faker = new Faker();
        String email = faker.pokemon().name().replace(" ","").toLowerCase() + "@gmail.com";
        Thread.sleep(3000);
        emailInputBox.sendKeys(faker.internet().emailAddress());
        Thread.sleep(3000);
        emailInputBox.clear();

        emailInputBox.sendKeys(email , Keys.ENTER);//to enter text

       Thread.sleep(5000);
       driver.close();
    }
}
