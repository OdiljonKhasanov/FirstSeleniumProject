package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod
    public void loginPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
//        driver.findElement(By.id("prependedInput")).sendKeys("user1");
//        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
//        driver.findElement(By.id("_submit")).click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        SeleniumUtils.sleep(3);
    }


    @Test
    public void test1VehicleTitle(){
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(3);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(1);
        driver.findElement(By.linkText("Vehicles")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(1);

        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();

//        String expectedPageName = "Cars";
//        String actualPageName = driver.findElement(By.className("oro-subtitle")).getText();



        Assert.assertEquals(expectedTitle,actualTitle);
        //Assert.assertEquals(expectedPageName,actualPageName);

    }

    @Test
    public void test2VehiclePageName (){
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(3);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(1);
        driver.findElement(By.linkText("Vehicles")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(1);
        String expectedPageName = "Cars";
        String actualPageName = driver.findElement(By.className("oro-subtitle")).getText();
        Assert.assertEquals(expectedPageName,actualPageName);
    }

    @Test
    public void test3AccountPageName (){
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(3);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        SeleniumUtils.sleep(1);
        driver.findElement(By.linkText("Accounts")).click();
        SeleniumUtils.sleep(1);
        String expectedPageName = "Accounts";
        String actualPageName = driver.findElement(By.className("oro-subtitle")).getText();

        String expectedTitle = "Accounts - Customers";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

        Assert.assertEquals(actualPageName,expectedPageName);
    }

    @Test
    public void test4ContacntsPageName (){
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(3);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        SeleniumUtils.sleep(1);
        driver.findElement(By.linkText("Contacts")).click();
        SeleniumUtils.sleep(6);

        String expectedPageName = "Contacts";
        String actualPageName = driver.findElement(By.cssSelector("[class='oro-subtitle']")).getText();

        String expectedTitle = "Contacts - Customers";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

        Assert.assertEquals(actualPageName,expectedPageName);
    }

    @Test
    public void test5CalendarPageName (){
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(3);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
        SeleniumUtils.sleep(1);
        driver.findElement(By.linkText("Calendar Events")).click();
        SeleniumUtils.sleep(1);

        String expectedPageName = "Calendar Events";
        String actualPageName = driver.findElement(By.cssSelector(".oro-subtitle")).getText();

        String expectedTitle = "Calendar Events - Activities";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

        Assert.assertEquals(actualPageName, expectedPageName);
    }

    @Test
    public void test6StoreManagerDashboardPage (){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.sleep(5);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("[class='title title-level-1']:nth-of-type(1)")).click();
        SeleniumUtils.sleep(3);
        driver.findElement(By.linkText("Dashboard")).click();
        SeleniumUtils.sleep(3);

        String expectedPageName = "Dashboard";
        String actualPageName = driver.findElement(By.cssSelector(".oro-subtitle")).getText();

        String expectedTitle = "Dashboard - Dashboards";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println(actualPageName);
        Assert.assertEquals(actualPageName,expectedPageName);

    }

    @Test
    public void test7StoreManagerFleetPage(){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.sleep(5);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();
        SeleniumUtils.sleep(3);
        driver.findElement(By.linkText("Vehicles")).click();
        SeleniumUtils.sleep(5);
        String expectedPageName = "All Cars";
        String actualPageName = driver.findElement(By.cssSelector("[class='oro-subtitle']")).getText();

        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

        Assert.assertEquals(actualPageName, expectedPageName);

    }

    @Test
    public void test8StoreManagerAccountsPage(){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.sleep(5);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
        SeleniumUtils.sleep(3);
        driver.findElement(By.linkText("Accounts")).click();
        SeleniumUtils.sleep(5);


        String expectedPageName = "All Accounts";
        String actualPageName = driver.findElement(By.cssSelector("[class='oro-subtitle']")).getText();

        String expectedTitle = "All - Accounts - Customers";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

        Assert.assertEquals(actualPageName, expectedPageName);
    }

    @Test
    public void test9StoreManagerContactsPage(){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.sleep(5);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]/a/span")).click();
        SeleniumUtils.sleep(3);
        driver.findElement(By.linkText("Contacts")).click();
        SeleniumUtils.sleep(5);

        String expectedPageName = "All Contacts";
        String actualPageName = driver.findElement(By.cssSelector("[class='oro-subtitle'] ")).getText();

        String expectedTitle = "All - Contacts - Customers";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

        Assert.assertEquals(actualPageName,expectedPageName);
    }

    @Test
    public void test10StoreManagerOpportunitiesPage(){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.sleep(5);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[4]/a/span")).click();
        SeleniumUtils.sleep(3);
        driver.findElement(By.linkText("Opportunities")).click();
        SeleniumUtils.sleep(5);

        String expectedPAgeName = "Open Opportunities";
        String actualPageName = driver.findElement(By.cssSelector("[class='oro-subtitle']")).getText();

        String expectedTitle = "Open Opportunities - Opportunities - Sales";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

        Assert.assertEquals(actualPageName, expectedPAgeName);

    }

    @Test
    public void test11StoreManagerCallsPage(){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.sleep(5);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span")).click();
        SeleniumUtils.sleep(3);
        driver.findElement(By.linkText("Calls")).click();
        SeleniumUtils.sleep(5);

        String expectedPageName = "All Calls";
        String actualPageName = driver.findElement(By.className("oro-subtitle")).getText();

        String expectedTitle = "All - Calls - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Assert.assertEquals(expectedPageName, actualPageName);



    }

    @Test
    public void test11StoreManagerCalendarEventsPage(){

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager51");

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.sleep(5);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span")).click();
        SeleniumUtils.sleep(3);
        driver.findElement(By.linkText("Calendar Events")).click();
        SeleniumUtils.sleep(5);

        String expectedPageName = "All Calendar Events";
        String actualPageName = driver.findElement(By.cssSelector(".oro-subtitle")).getText();

        String expectedPageTitle = "All - Calendar Events - Activities";
        String actualPageTitle = driver.getTitle();
        System.out.println(actualPageTitle);
        Assert.assertEquals(actualPageName,expectedPageName);
        Assert.assertEquals(actualPageTitle,expectedPageTitle);

    }

    @AfterMethod
    public  void tearDown(){
        driver.close();
    }

}
