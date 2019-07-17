package com.cybertek.tests.VyTrack;

import com.cybertek.tests.BrowserFactory;
import com.cybertek.tests.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWork {

      static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {


        driver.manage().window().maximize();
        //test1();
        //Etsy();
        //VyTrackTitleTest();
        VytrackShortcutFunctionality();

        //driver.close();
    }
public static void test1(){ // READY!!!

        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("selenium web browser automation", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/div/cite")).click();

        String expectedURL = "https://www.seleniumhq.org/";
        String actualURL = driver.getCurrentUrl();
        String resultURL = (expectedURL.equals(actualURL))? "URL is correct": "URL is NOT correct";
        System.out.println(resultURL);
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div/div[1]/input")).clear();

        List<String> searchStrs = Arrays.asList("selenium web browser automation", "Java", "JUnit", "REST Assured");
        List<String> expectedURLs = Arrays.asList("https://www.seleniumhq.org/","https://www.java.com/en/","https://junit.org/junit5/","http://rest-assured.io/");

        List<WebElement> LinkClasses = driver.findElements(By.tagName("h3"));

        for (int i = 0; i < searchStrs.size(); i++){

            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div/div[1]/input")).sendKeys(searchStrs.get(i),Keys.ENTER);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.tagName("h3")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           // System.out.println(driver.getCurrentUrl());
            String eachURLResult = (driver.getCurrentUrl().contains(expectedURLs.get(i)))? "" + driver.getCurrentUrl() + " is correct URL": "" + driver.getCurrentUrl() + " is WRONG URL";
            System.out.println(eachURLResult);
            driver.navigate().back();
            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div/div[1]/input")).clear();

        }

    }

    public static void Etsy(){//READY!!!

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://ebay.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon",Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String totalResult1 = driver.findElement(By.tagName("h1")).getText().replace(",","").substring(0,5);
        Integer i1 = Integer.valueOf(totalResult1);
        System.out.println(i1);

        driver.findElement(By.linkText("All")).click();
        String totalResult2 = driver.findElement(By.tagName("h1")).getText().replace(",","").substring(0,5);
        Integer i2 = Integer.valueOf(totalResult2);
        System.out.println(i2);

        String isBigger = (i2>i1)?"PASS: " + i2 + " Result All link is bigger" : "FAIL: " + i1 + " Result before All link is bigger";
        System.out.println(isBigger);

        driver.navigate().back();

        String expectedSearchValue = "wooden spoon";
        String actualSearchValue = driver.findElement(By.id("gh-ac")).getAttribute("value");

        String isCorrectDisplayedSearch = (actualSearchValue.equals(expectedSearchValue))? "PASS: Search box displayed Correct": "FAIL: Search box displayed incorrect";

        System.out.println(isCorrectDisplayedSearch);

        driver.navigate().back();

        String expectedEmptySearch = "";
        String actualEmptySearch = driver.findElement(By.id("gh-ac")).getAttribute("value");


        String homeSearchEmpty = (actualEmptySearch.equals(expectedEmptySearch))? "PASS: Homepage Search box is blank": "Fail: Homepage Search box is NOT blank";
        System.out.println(homeSearchEmpty);

    }

    public static void VyTrackTitleTest(){
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"user-menu\"]/ul/li[2]/a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String titleName = driver.getTitle();
        String dropdownDisplayName = driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a")).getText();
        System.out.println(titleName);
        System.out.println(dropdownDisplayName);

        String correctTitle = (titleName.startsWith(dropdownDisplayName))? "PASS: Correct title beginning": "FAIL: Incorrect title beginning";
        System.out.println(correctTitle);

    }

    public static void VytrackShortcutFunctionality(){

        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager101");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span")).click();//dashboards block
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span")).click();//dashboard option
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String dashboardURL = driver.getCurrentUrl();
        String verifyInDashboard = (dashboardURL.contains("dashboard"))? "PASS: Inside dashboard page" : "FAIL: Wrong page";
        System.out.println(verifyInDashboard);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(5);
        driver.findElement(By.className("fa-share-square")).click();
        SeleniumUtils.sleep(5);
        driver.findElement(By.linkText("See full list")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        SeleniumUtils.sleep(2);
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
        SeleniumUtils.sleep(2);
        String messageText = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div/div")).getText();
        String expectedMessageText = "You do not have permission to perform this action.";

        String messageResult = (messageText.equals(expectedMessageText))? "PASS: message appeared":"FAIL: Message did not appeared";
        System.out.println(messageResult);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Opportunities")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String openOpportunityULR = driver.getCurrentUrl();
        String opportunityResult = (openOpportunityULR.contains("opportunity"))?"PASS: Open Opportunity page is loaded": "FAIL: Open Opportunity page is NOT loaded";
        System.out.println(opportunityResult);






    }
}
