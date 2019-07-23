package com.cybertek.tests.Day14;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigurationReaderTests {

    @Test
    public void test1(){
        String expected = "chrome";
        String actual = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void test2 (){
        String expectedUserName = "user";
        String actualUserName = ConfigurationReader.getProperty("username");
        Assert.assertEquals(actualUserName,expectedUserName);
    }

}
