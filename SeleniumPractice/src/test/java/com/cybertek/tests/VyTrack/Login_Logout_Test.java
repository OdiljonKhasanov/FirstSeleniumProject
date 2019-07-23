package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login_Logout_Test {



    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://qa2.vytrack.com/user/login");
        library.sleep(1);

        driver.findElement(By.id("prependedInput")).sendKeys("user1");
        library.sleep(1);

        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        library.sleep(1);

        driver.findElement(By.id("_submit")).click();
        library.sleep(1);

        String expectedLoginURL = "http://qa2.vytrack.com/";
        String actualLoginURL = driver.getCurrentUrl();

        String resultLogin = (expectedLoginURL.equals(actualLoginURL))? "Login successful!": "Login failed";
        System.out.println(resultLogin);


        driver.findElement(By.className("dropdown-toggle")).click();
        library.sleep(1);

        driver.findElement(By.linkText("Logout")).click();


        String expectedLogoutURL = "http://qa2.vytrack.com/user/login";
        String actualLogoutURL = driver.getCurrentUrl();
        String resultLogout = (expectedLogoutURL.equalsIgnoreCase(actualLogoutURL))? "Logout successful!": "Logout failed";
        System.out.println(resultLogout);
        library.sleep(1);

        driver.close();




    }

}
