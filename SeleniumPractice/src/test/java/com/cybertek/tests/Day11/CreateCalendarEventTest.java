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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class CreateCalendarEventTest {

    WebDriver driver;
    String createCalendarEventButtonLocator = "a[title='Create Calendar event']";
    String cancelButtonLocator = "a[title='Cancel']";
    //locators for save and close dropdown
    String saveAndCloseButtonLocator = "//div/button[contains(text(),'Save and Close')]";
    String saveAndCloseDropdownLocator = "a[class='btn-success btn dropdown-toggle']";
    String saveAndCloseOptionLocator = "//li/button[contains(text(),'Save and Close')]";
    String saveAndNewOptionLocator = "//li/button[contains(text(),'Save and New')]";
    String saveOptionLocator = "(//li/button[contains(text(),'Save')])[3]";

    String currentUserLocator = "#user-menu > a";
    String selectedOwnerLocator = ".select2-chosen";
    String titleLocator = "[id^='oro_calendar_event_form_title']";
    String startDateLocator = "[id^='date_selector_oro_calendar_event_form_start']";
    String startTimeLocator = "[id^='time_selector_oro_calendar_event_form_start']";


    @BeforeMethod
    public void setup() {
        //driver setup
        WebDriverManager.chromedriver().setup();
        //to initialize driver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        VyTrackUtils.login(driver, "salesmanager253", "UserUser123");
    }

    @Test
    public void verifyCancelButton() {
        VyTrackUtils.navigatetoModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.sleep(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.sleep(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());
    }

    @Test
    public void verifySaveAndCloseDropdown() {
        VyTrackUtils.navigatetoModule(driver, "Activities", "Calendar Events");
        SeleniumUtils.sleep(2);
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.sleep(2);

        //verify save and close button is displayed (visible)
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseButtonLocator)).isDisplayed());

        //click on toggle to make dropdown options visible
        //driver.findElement(By.cssSelector(saveAndCloseDropdownLocator)).click();
        SeleniumUtils.clickWithWait(driver, By.cssSelector(saveAndCloseDropdownLocator), 4);
        //verify dropdown options are visible
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseOptionLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveAndNewOptionLocator)).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(saveOptionLocator)).isDisplayed());
    }

    @Test
    public void verifyDefaultOwner(){
        VyTrackUtils.navigatetoModule(driver, "Activities", "Calendar Events");
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.sleep(2);

        String expectedOwner = driver.findElement(By.cssSelector(currentUserLocator)).getText().trim();
        String actualOwner = driver.findElement(By.cssSelector(selectedOwnerLocator)).getText().trim();

        Assert.assertEquals(actualOwner, expectedOwner);
    }

    @Test
    public void verifyTitle(){
        VyTrackUtils.navigatetoModule(driver, "Activities", "Calendar Events");
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.sleep(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(titleLocator)).getAttribute("value").length() == 0);
    }

    @Test
    public void verifyStartDateAndTime(){
        VyTrackUtils.navigatetoModule(driver, "Activities", "Calendar Events");
        driver.findElement(By.cssSelector(createCalendarEventButtonLocator)).click();
        SeleniumUtils.sleep(2);

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy"));
        String actualDate = driver.findElement(By.cssSelector(startDateLocator)).getAttribute("value");

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
        String actualTime = driver.findElement(By.cssSelector(startTimeLocator)).getAttribute("value");

        Assert.assertEquals(actualDate, expectedDate);
        Assert.assertEquals(actualTime, expectedTime);
    }



    @AfterMethod
    public void teardown() {
        driver.close();
    }


}
