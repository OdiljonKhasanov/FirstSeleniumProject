package com.cybertek.tests.OfficeHour_July11;

import com.cybertek.utilities.library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGReview {

    WebDriver driver;

    @BeforeMethod
    public void setUp1(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        library.sleep(3);

    }


    @Test(
            priority = 2 ,
            description = "Verify the URL",
            timeOut =  4000,
            enabled = false
    )
    public void test1(){
        String URL = driver.getCurrentUrl();
        System.out.println( URL.contains("www.facebook.com") );

    }

    @Test( priority = -100,
            description = "Verify the Title",
            timeOut = 4000,
            enabled = false
    )
    public void test2(){

        String title =  driver.getTitle().toLowerCase();
        System.out.println( title.contains("facebook") );

    }
/*
tagname: button
linktext: Sign Up
//button[text()='Sign Up']
// button[contains(text(),'Sign')]
 */

    @Test(description = "Verify Sign up Button")
    public void TestCase4(){
        WebElement SignUp = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        System.out.println( SignUp.isEnabled());

    }




    @AfterMethod
    public void teardown(){
        library.sleep(2.5);
        driver.quit();

    }

    /*
    Topic: TestNG

                @Test: a test case
                    priority: decides which @Test method to run first. (in Acsending order)
                    enable: if true (deafult): @Test will be executed,   if false: @test will be ignored
                    description: is used to write test case description, (explains the test case)
                    invocationcount: decides how many time the test case should be executed
                    timeout: gives time limitis to test case
                    expectedexceptions: defines that the test case might throw an unchecked


            TestNG Annotations:
                    controls how the @Test(TestNG' ) should be executed

                    @BeforeMethod:  runs before  each @Test Methods
                    @AfterMethod:   runs after the completion of each @Test methods
                    @BeforeClass:   runs before the first @Test method of the class
                    @AfterClass:    runs after the completion of last @Test method



     */
    @Test(priority = 1 , enabled = false )
    public void TestCase1(){
        System.out.println("Test case 1 is completed");
    }

    @Test(priority = -1  , description = "This is testing testNG" )
    public void TestCase2(){

        System.out.println("Test case 2 is completed");

    }


    @Test(invocationCount = 100)
    public void TestCase3(){

        System.out.println("Test case 3 is completed");

    }


//    @Test ( timeOut = 3000 )
//    public void TestCase4() throws Exception{
//        Thread.sleep(4000);
//        System.out.println("test Case 4 is completed");
//
//    }


    @Test ( expectedExceptions = ArrayIndexOutOfBoundsException.class )
    public void TestCase5(){
        System.out.println("Test 5 completed");

        int[] arr = new int[]{1,2,3,4,5};
        System.out.println( arr[100] );    //   return;
        System.out.println("Extra test step");


    }

}
