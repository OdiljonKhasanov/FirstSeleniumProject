package com.cybertek.tests.Day9;
import com.cybertek.tests.BrowserFactory;
import com.cybertek.tests.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class RelativeXpath {

    WebDriver driver;
    String button1Locator = "//button[.='Button 1']";
    String button2Locator = "//*[contains(@name,'button2')]";
    String button3Locator = "//button[starts-with(@id,'button_')]";
    String button4Locator = "//button[contains(text(),'Button 4')]";
    String button5Locator = "//button[5]";
    String button6Locator = "//*[@id='disappearing_button']";
    String resultLocator = "//p[@id='result']";
    String allButtonsLocator = "//button[starts-with(@onclick,'button')]";



    @BeforeClass
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }

    @Test
    public void verifyButton3(){
        String expectedMessage = "Clicked on button three!";
        driver.findElement(By.xpath(button3Locator)).click();

        SeleniumUtils.sleep(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void verifyButton4(){
        String expectedMessage = "Clicked on button four!";
        driver.findElement(By.xpath(button4Locator)).click();
        SeleniumUtils.sleep(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void verifyButton6(){
        String expectedMessage = "Now it's gone!";
        driver.findElement(By.xpath(button6Locator)).click();
        SeleniumUtils.sleep(2);
        String actualMessage = driver.findElement(By.xpath(resultLocator)).getText();
        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertFalse(driver.findElements(By.xpath(button6Locator)).size()==0);

    }

    @Test
    public void clickOnEveryButton(){
        List<WebElement> buttons = driver.findElements(By.xpath(allButtonsLocator));
        for(WebElement button: buttons){
            button.click();
            SeleniumUtils.sleep(1);
        }


    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
