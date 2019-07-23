package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;
    private Driver(){}

    public static WebDriver getDriver(){
        if(driver==null){
//            if(ConfigurationReader.getProperty("browser").equals("chrome")){
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }else if(ConfigurationReader.getProperty("browser").equals("firefox")){
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }else{
//                throw new RuntimeException("Wrong browser name!");
//
//            }

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Illegal browser name!");
            }
        }
        return driver;
    }
    //will kill driver
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }

}
