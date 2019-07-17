package com.Odiljon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Odiljon\\Documents\\selenium dependencies\\drivers\\chromedriver.exe")

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
