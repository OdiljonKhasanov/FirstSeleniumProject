package com.cybertek.tests.Day11;

import com.cybertek.tests.SeleniumUtils;
import com.cybertek.tests.VyTrackUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VyTrackAutomation {

   WebDriver driver;

   String createButtonLocator = "a[title='Log call']";
   String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
   @BeforeMethod
    public void setup(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("http://qa2.vytrack.com/user/login");
   }

   @Test
   public void StoreManagerTest(){

       //login
       VyTrackUtils.login(driver,"storemanager51","UserUser123");
       //navigate to module
       VyTrackUtils.navigatetoModule(driver,"Activities","Calls");
       SeleniumUtils.sleep(3);
       Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
       SeleniumUtils.sleep(1);
       VyTrackUtils.navigatetoModule(driver,"Activities", "Calendar Events");
       Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());


   }

    @Test (priority = 2)
    public void salesManagerTest(){
        //login
        VyTrackUtils.login(driver, "salesmanager253", "UserUser123");
        //navigate to the Calls
        VyTrackUtils.navigatetoModule(driver, "Activities", "Calls");
        //assert true that button "log call" is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createButtonLocator)).isDisplayed());
        SeleniumUtils.sleep(1);
        //navigate to the Calendar Events
        VyTrackUtils.navigatetoModule(driver, "Activities", "Calendar Events");
        //Verify that Create Calendar Event is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).isDisplayed());
    }

   @AfterMethod
    public void teardown(){
       driver.quit();
   }

}
