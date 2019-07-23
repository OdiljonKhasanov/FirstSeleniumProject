package com.cybertek.tests.BriteERP;


import com.cybertek.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupProjectTests {

    WebDriver driver;
    String emailBoxLocator = "#login";
    String passwordLOcator = "#password";
    String submitLocator = "[type='submit']";
    String searchLocator = "[placeholder='Search...']";
    String productNameLocator = "[placeholder='Product Name']";
    String createButtonLocator = "[accesskey='c']";
    String saveButtonLocator = "[accesskey='s']";


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
    }

    @Test (description ="manager should able to search inventory")
    public void SearchInventory(){

        driver.findElement(By.cssSelector(emailBoxLocator)).sendKeys("imm10@info.com");
        driver.findElement(By.cssSelector(passwordLOcator)).sendKeys("inventorymanager");
        driver.findElement(By.cssSelector(submitLocator)).click();

        driver.findElement(By.linkText("Inventory")).click();

        driver.findElement(By.linkText("Products")).click();

        WebElement search = driver.findElement(By.cssSelector(searchLocator));
        //driver.findElement(By.cssSelector(searchLocator)).sendKeys("apple");
        search.sendKeys("apple");

        search.click();

        //Assert.assertTrue(driver.findElement(By.cssSelector(searchLocator)).isEnabled());
    }

    @Test(description = "manager Should able add product to inventory")
    public void addProduct(){
        driver.findElement(By.cssSelector(emailBoxLocator)).sendKeys("imm10@info.com");
        driver.findElement(By.cssSelector(passwordLOcator)).sendKeys("inventorymanager");
        driver.findElement(By.cssSelector(submitLocator)).click();
        driver.findElement(By.linkText("Inventory")).click();
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.cssSelector(createButtonLocator)).click();
        Faker faker = new Faker();
        String fakeItem = faker.beer().name();
        driver.findElement(By.cssSelector(productNameLocator)).sendKeys(fakeItem);
        Assert.assertTrue(driver.findElement(By.cssSelector(saveButtonLocator)).isEnabled());
        driver.findElement(By.cssSelector(saveButtonLocator)).click();

    }


//    @AfterMethod
//    public void teardown(){
//
//        driver.close();
//    }

}
