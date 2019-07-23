package com.cybertek.tests.Day7;

import com.cybertek.utilities.BrowserFactory;
import com.cybertek.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownPractice {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openDropDownPage();
        //test1();
        test2();
        //test3();
        //test4();
        //test5();
        //test6();


        driver.close();

    }

    public static void openDropDownPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
//        String expected = "Dropdown List";
//        String actual = driver.findElement(By.tagName("h3")).getText();
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplayed(element);

    }

    public static void test1(){
        WebElement dropdown1 = driver.findElement(By.id("dropdown"));
        //to work with select elements
        //we need to use Select class
        //don't forget to pass web element of that dropdown that you found into constructor
        Select dropdownSelect = new Select(dropdown1);
        //since dropdown consists of options
        //we can check which one is selected
        //getFirstSelectedOption() return webelement, use getText() method if
        //you want to get a text of this option, Usally, text is a visible part of
        //dropdown. Value or other attributes of drop down, not visible.
        String actual = dropdownSelect.getFirstSelectedOption().getText();
        String expected = "Please select an option";
        SeleniumUtils.verifyEquals(expected, actual);
        //we can get list of options that are present in the dropdown
        List<WebElement> options = dropdownSelect.getOptions();
        for(WebElement option: options){
            System.out.println(option.getText());
        }
    }

    public static void test2(){
        WebElement dropDownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropDownState);
        List<WebElement> states = dropDownSelect.getOptions();
        for(WebElement element: states){
            System.out.println(element.getText());
        }

        //lets select Virginia
        //we have to use object of Select class

        dropDownSelect.selectByVisibleText("Virginia");
        SeleniumUtils.waitPlease(1);
        dropDownSelect.selectByVisibleText("California");
        SeleniumUtils.waitPlease(1);
        dropDownSelect.selectByVisibleText("Texas");
        SeleniumUtils.waitPlease(1);
        dropDownSelect.selectByVisibleText("Kansas");
        SeleniumUtils.waitPlease(1);
        dropDownSelect.selectByVisibleText("New Jersey");
        SeleniumUtils.waitPlease(1);
        dropDownSelect.selectByVisibleText("Florida");
        SeleniumUtils.waitPlease(1);

    }

        public static void test3() {
            WebElement dropdownState = driver.findElement(By.id("state"));
            Select dropDownSelect = new Select(dropdownState);
            List<WebElement> states = dropDownSelect.getOptions();

            for(WebElement option : states){
                SeleniumUtils.waitPlease(1);

                dropDownSelect.selectByVisibleText(option.getText());
            }

    }

    public static void test4(){

        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
       dropDownSelect.selectByValue("PA");
       SeleniumUtils.waitPlease(2);
       String expected = "Pennsylvania";
       String actual = dropDownSelect.getFirstSelectedOption().getText();
       SeleniumUtils.verifyEquals(expected, actual);
    }

    //select by index
    public static void test5(){
        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        SeleniumUtils.waitPlease(2);
        dropDownSelect.selectByIndex(5);
        SeleniumUtils.waitPlease(2);

    }
    public static void test6(){

        WebElement multipleSelectionWebElement = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select multipleSelectionSelect = new Select(multipleSelectionWebElement);
        SeleniumUtils.waitPlease(2);
        multipleSelectionSelect.selectByVisibleText("Java");
        SeleniumUtils.waitPlease(2);
        multipleSelectionSelect.selectByVisibleText("JavaScript");
        SeleniumUtils.waitPlease(2);



    }


}
