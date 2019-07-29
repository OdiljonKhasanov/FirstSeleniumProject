package com.cybertek.tests.Day16;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTableTests extends TestBase
{

    @Test
    public void printTableTest (){

        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());

    }

    @Test
    public void printHeaderRow(){
        WebElement header = driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println(header.getText());
    }

    @Test//without header, number of rows in the first table
    public void countRowsTest(){
        //means find table with id table1 then go to tbody and any tr
        //it represents number of rows in the first table
        String locator = "table[id='table1'] > tbody>tr ";
        List<WebElement> rows = driver.findElements(By.cssSelector(locator));
        System.out.println("Size: " + rows.size());
    }

    //get number of rows in the second table, including heading
    @Test
    public void countRowsTest2(){
        String locator = "#table2 tr";
        List<WebElement> rows = driver.findElements(By.cssSelector(locator));
        System.out.println(rows.size());
    }

    @Test
    public void printTableHeaders(){
        String locator = "#table1 th";
        List<WebElement> headers = driver.findElements(By.cssSelector(locator));
        for(WebElement each: headers){
            System.out.println(each.getText());
        }

        for(int row =0; row <4;row++){
            String columnLocator = "//table[1]//tr["+row+"]/td[1]";
           WebElement column = driver.findElement(By.xpath(columnLocator));
            System.out.println(column.getText());
        }
    }

    @Test
    public void printSpecificRow(){
        int row = 3;

        // with css ->  table:nth-of-type(1) tr:nth-of-type(3)
        String locator = "//table[1]//tbody//tr["+row+"]";
        WebElement rowElement = driver.findElement(By.xpath(locator));
        System.out.println(rowElement.getText());

    }

    //let's write a method that will return column based on column name

    public  List<String>getColumn(String columnName){
        List<String> values = new ArrayList<>();

        //all headings
        List<WebElement> headings = driver.findElements(By.xpath("//table[1]//th"));
        int columnNumber = 0;
        //we are looking for position of heading
        for(int i =0; i < headings.size(); i++){
            // we are looking thought collection of heading
            if(headings.get(i).getText().equals(columnName)){
                columnNumber = i+1;
                break;
            }
        }

        //based on position that we found in previous loop, we allocating column
        List<WebElement>columnList = driver.findElements(By.xpath("//table[1]//tr//td["+columnNumber+"]"));

        for(WebElement columnValue: columnList){
            values.add(columnValue.getText());
        }
        return values;
    }

    @Test
    public void printColumn(){
        System.out.println(getColumn("Email"));
    }

    @Test
    public void verifyThatNameDisplays(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String actualName = driver.findElement(By.xpath(firstNameLocator)).getText();
        String actualLastName = driver.findElement(By.xpath(lastNameLocator)).getText();

        Assert.assertEquals(actualName, firstName);
        Assert.assertEquals(actualLastName, lastName);
    }



    @Test(dependsOnMethods = "verifyThatNameDisplays")
    public void verifyThatRecordHasBeenDeletedTest(){
        String firstName = "Jason";
        String lastName = "Doe";
        String firstNameLocator = "//table[1]//tbody//tr[3]//td[2]";
        String lastNameLocator = "//table[1]//tbody//tr[3]//td[1]";

        String target = "//table[1]//td[text()='"+lastName+"']";

        String deleteLocator = "//table[1]//td[text()='"+lastName+"']/following-sibling::td//a[text()='delete']";

        driver.findElement(By.xpath(deleteLocator)).click();

        Assert.assertTrue(driver.findElements(By.xpath(target)).isEmpty());
    }

}
