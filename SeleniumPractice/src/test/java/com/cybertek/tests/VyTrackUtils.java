package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import static com.cybertek.tests.SeleniumUtils.sleep;

public class VyTrackUtils {
    //we don't want to access these variables outside
    private static String usernameLocator = "prependedInput";
    private static String passwordLocator = "prependedInput2";

    /**
     * Login into vytrack application
     * @param driver
     * @param username
     * @param password
     */
    public static void login(WebDriver driver, String username, String password){

        driver.findElement(By.id(usernameLocator)).sendKeys(username);
        //Keys.ENTER means click enter after entering password
        //in this way, we don't need to click login button
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        sleep(3);
    }

    public static void navigatetoModule(WebDriver driver, String tab, String module){
        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'title title-level-2')]";

        sleep(3);
        driver.findElement(By.xpath(tabLocator)).click();
        sleep(1);
        driver.findElement(By.xpath(moduleLocator)).click();
        sleep(2);
    }


}
