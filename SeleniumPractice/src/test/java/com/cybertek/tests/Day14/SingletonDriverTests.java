package com.cybertek.tests.Day14;

import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import org.testng.annotations.Test;

public class SingletonDriverTests {


    @Test
    public void test(){

        Driver.getDriver().get("https://google.com/");

        SeleniumUtils.waitPlease(3);
        Driver.closeDriver();
    }
}
