package com.cybertek.tests.Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) throws Exception {
        //this line replaces System.setProperty("webdriver", "pah to the webdriver")
        WebDriverManager.chromedriver().setup(); //setup webdriver
        //driver will give us access to the browser
        WebDriver driver = new ChromeDriver(); // create object of chrome driver
        driver.manage().window().maximize(); // open browser maximized
        driver.get("http://practice.cybertekschool.com/forgot_password"); // open url

        WebElement emailInputBox = driver.findElement(By.name("email")); //we found input box
        WebElement submitButton = driver.findElement(By.id("form_submit"));//we found submit button

        emailInputBox.sendKeys("email@gmail.com");//to enter text

        Thread.sleep(2000);

        submitButton.click();//we are clicking submit button

        Thread.sleep(2000); //waiting 2 seconds

        //let's find confirmation message and verify it

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));

        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = confirmationMessage.getText(); // how to get text of element
        //we verify that expected message is the same as on the page
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test passed");
        }else {
            System.out.println("Test failed");
            System.out.println("Expcted message: "+expectedMessage);
            System.out.println("Actual message: "+actualMessage);
        }


        driver.close();// selenium clean up after yourself, close browser
    }
}
