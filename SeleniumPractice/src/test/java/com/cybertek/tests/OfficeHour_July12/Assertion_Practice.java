package com.cybertek.tests.OfficeHour_July12;

import com.cybertek.tests.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assertion_Practice {
    WebDriver driver;

    @BeforeClass
    public void XX(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*
         implicity wait time:   maximum wait for lacting element is 10 seconds,
             if the element is located within 2 or 3 seconds, it deos not wait the remining seconds

         Thread.sleep(10000):  it MUST wait 10 seconds regardless of what
         */


    }


    @Test(
            priority = 1 ,
            description = "Verify URL and Title, Postive test",
            timeOut = 5000
    )
    public void Test1(){

        //   library.sleep(5);
        assertTrue(  driver.getTitle().contains("Facebook")  );
        assertTrue( driver.getCurrentUrl().equals("https://www.facebook.com/") );

        assertEquals( driver.getTitle(), "Facebook - Log In or Sign Up" );
        assertEquals( driver.getCurrentUrl(), "https://www.facebook.com/"  );


        System.out.println("test 1 completed");

    }




    @Test(
            priority = 2,
            description = "Verify URL and Title, negative"

    )
    public void Test2(){

        assertFalse( driver.getTitle().contains("Google") );
        assertFalse( driver.getCurrentUrl().equals("www.google.com")  );

        System.out.println("Test 2 completed");


    }



    @Test(description = "Verify all drop down boxes working properly")
    public void Test3(){

        /*
        //select[@class='_5dba']
         */

        List<WebElement> list = driver.findElements(By.xpath("//select[@class='_5dba']"));
        // to verify all drop down boxes are enabled
        for(WebElement each : list ) {
            assertTrue( each.isEnabled() );
            library.sleep(1);
        }


        WebElement MonthDropDownBox = list.get(0);
        Select Month = new Select(MonthDropDownBox);
        // select class is used for hadling drop down boxes with tagname of select

        List<WebElement> Months =  Month.getOptions();
        WebElement July = null;
        // verify that July is selected by default
        for( WebElement each: Months){
            if(each.getText().equals("Jul")) {
                July = each;
                break;
            }
        }
        library.sleep(2.5);

        assertTrue(July.isSelected());

        library.sleep(3);

        // select by visible text:
        Month.selectByVisibleText("Oct");
        library.sleep(3);

        // select by index:
        Month.selectByIndex(3);
        library.sleep(3);

        // select By value:
        Month.selectByValue("9");




        System.out.println("Test 3 completed");

    }








    @AfterMethod
    public void teardown(){
        library.sleep(3.5);
        driver.quit();
    }
}
