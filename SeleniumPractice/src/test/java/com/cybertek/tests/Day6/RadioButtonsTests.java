package com.cybertek.tests.Day6;

import com.cybertek.tests.BrowserFactory;
import com.cybertek.tests.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonsTests {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openRadioButtonPage();
        //test1();
        //test2();
        //test3();
        test4();

        SeleniumUtils.sleep(2);
        driver.close();
    }
    //lets check if blue radio button is selected
    public static void test1(){

        WebElement blueBtn = driver.findElement(By.id("blue"));
        if(blueBtn.isSelected()){
            System.out.println("PASS");
        }else{
            System.out.println("FAILED");
        }

    }
    public static void test2(){

        WebElement blackBtn = driver.findElement(By.id("black"));
        WebElement greenBtn = driver.findElement(By.id("green"));

        if(blackBtn.isEnabled()&& (!greenBtn.isEnabled())){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

    }
    //verify that blue button is selected
    // then click on black button
    //verify that black button is selected
    //verify that blue button is not selected
    public static  void test3(){
        WebElement blackBtn = driver.findElement(By.id("black"));
        WebElement blueBtn = driver.findElement(By.id("blue"));

        if(blueBtn.isSelected()){
            System.out.println("PASSED: Blue button is selected");
        }else{
            System.out.println("FAILED: Blue button is NOT selected");
        }
        blackBtn.click();

        if(blackBtn.isSelected()&& (!blueBtn.isSelected())){
            System.out.println("PASSED: Black button is selected");
        }else{
            System.out.println("FAILED: Black button is not selected");
        }

    }
    //Let's write a test
    //that will make sure
    //that only one radio button is selected
    public static void test4(){
    // Step 1. Let's find all radio buttons
        List<WebElement>listOfRadioButtons = driver.findElements(By.xpath("//input[@type='radio']"));
        //let's create counter, to count
        //how many selected radio buttons
        int counter = 0;
        //we will go through list of web elements
        //and check one by one
        //which radio button is selected
        //if radio button is selected
        //increase counter

        for(WebElement radioButton: listOfRadioButtons){
            //get id of selected radio button
            System.out.println(radioButton.getAttribute("id"));
            counter++;
        }

        System.out.println(counter);



    }

    public static void openRadioButtonPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");
    }

}
