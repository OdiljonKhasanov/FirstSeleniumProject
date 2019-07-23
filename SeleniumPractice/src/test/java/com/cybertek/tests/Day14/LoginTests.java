package com.cybertek.tests.Day14;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import com.cybertek.tests.VyTrack.LogInPage;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    LogInPage loginPage = new LogInPage();

    @Test
    public void loginTests1(){
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        loginPage.login(username, password);
    }
}
