package com.cybertek.tests.OfficeHour_July31;

import com.cybertek.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDownDemp {

    /*
          The first dropdown that we have a tag Select
          Select class will be created and then we will use from the select object
     */
    @Test
    public void dropdownTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get("https://www.hotels.com/");
        WebElement dropDownList = driver.findElement(By.xpath("//select[@id='qf-0q-compact-occupancy']"));
        Select select = new Select(dropDownList);
        for (int idx = 0; idx <select.getOptions().size(); idx++){
            System.out.println(select.getOptions().get(idx).getText());
        }
        // customize way of doing the select
        //1): we use from select by Index
        select.selectByIndex(1);
        Assert.assertTrue(select.getOptions().get(1).isSelected());

        //2): selectByVisibleText("pass the exact text from dropdown");
        select.selectByVisibleText("More options…");

        //3): selectByValue("2");
    }

}
