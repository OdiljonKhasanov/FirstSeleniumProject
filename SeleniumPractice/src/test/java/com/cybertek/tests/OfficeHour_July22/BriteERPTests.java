package com.cybertek.tests.OfficeHour_July22;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BriteERPTests {

    WebDriver driver = Driver.getDriver();

    @BeforeMethod
    public void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
}
