package com.cybertek.tests.Day13;

import com.cybertek.tests.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsClass {
    WebDriver driver;
    String user1TextLocator = "//a[@href='/users/1']/preceding-sibling::h5";
    String firstImageLocator = "(//img)[1]";
    String enabledOptionLocator = "ui-id-3";
    String downloadsOptionLocator = "ui-id-4";
    String pdfoptionLocator = "ui-id-5";

    //drag and drop
    String moonLocator = "draggable";
    String earthLocator = "droptarget";

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void hoverTest1(){
        driver.get("http://practice.cybertekschool.com/hovers");
        //we are creating object of Actions class
        //we have provide object of webdriver
        Actions action = new Actions(driver);
        //hover on element
        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();
        String expectedText = "name: user1";
        String actualText = driver.findElement(By.xpath(user1TextLocator)).getText();

        //verify that after hover event text is visible
        Assert.assertTrue(driver.findElement(By.xpath(user1TextLocator)).isDisplayed());
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void hoverTest2(){
        driver.get("http://practice.cybertekschool.com/hovers");
        //we are creating object of Actions class
        //we have provide object of webdriver
        Actions action = new Actions(driver);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement image: images){
            //ONLY DEMO
            SeleniumUtils.sleep(1);
            action.moveToElement(image).perform();
        }

    }

    @Test
    public void hoverTest3(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Actions action = new Actions(driver);
        WebElement enabledElement = driver.findElement(By.id(enabledOptionLocator));
        WebElement downloadsElement = driver.findElement(By.id(downloadsOptionLocator));
        WebElement pdfElement = driver.findElement(By.id(pdfoptionLocator));
        action.moveToElement(enabledElement).
                pause(1000).moveToElement(downloadsElement).
                pause(1000).moveToElement(pdfElement).
                click().
                build().
                perform();
        SeleniumUtils.sleep(2);//JUST FOR DEMO
    }


    @Test
    public void dragAndDropTest1 (){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions action = new Actions(driver);
        WebElement moon = driver.findElement(By.id(moonLocator));//source
        WebElement earth = driver.findElement(By.id(earthLocator));// target

        action.dragAndDrop(moon, earth).perform();
        String expectedMessage = "You did great!";
        String actualMessage = earth.getText();

        Assert.assertEquals(actualMessage, expectedMessage);
        SeleniumUtils.sleep(3);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
