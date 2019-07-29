package com.cybertek.tests.Day17;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class WebTableTests2 extends TestBase {

    /**
     * Write a method that will return count of rows
     * make
     * */

    public int getCountofrows(){
        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }

    /**
     * Write a method that will return count of rows
     * In this case, object of By allows us to specify table locator any type
     * */
    public int getCountofrows(By by){
        return driver.findElements(by).size();
    }

    @Test
    public void countRowsTest1(){
        Assert.assertEquals(getCountofrows(),5,"Numbers of rows doesn't match");
        System.out.println(getCountofrows());
    }

    @Test
    public void countRowsTest2(){
        Assert.assertEquals(getCountofrows(By.xpath("//table[1]//tr")),5,"Numbers of rows doesn't match");
    }

    /**
     * Write method that returns number of columns
     * */

    @Test
    public int getCountColumns(){
        return driver.findElements(By.cssSelector("#table1 th")).size();

    }

    /**
     * Write method that returns number of columns
     * */


    public int getCountColumns(By by){
        return driver.findElements(by).size();

    }

    @Test
    public void countofColumnsTest1(){
        Assert.assertEquals(getCountColumns(), 6, "Numbers of columns doesn't match");
    }

    @Test
    public void countofColumnsTest2(){
        Assert.assertEquals(getCountColumns(By.xpath("//table[1]//th")), 6, "Numbers of columns doesn't match");
    }

    /**
     * Lets write a method that will return table size
     * First value - number of columns
     * Secont value - number of columns
     * */

    public int []getTableSize(){
        int [] size = {getCountofrows(), getCountColumns()};
        return size;
    }

    /**
     * Lets write a method that will return table size
     * First value - number of columns
     * Secont value - number of columns
     * by -  represents locator for table
     * */

    public int []getTableSize(By columnlocator, By rowlocator){
        int [] size = {getCountofrows(rowlocator), getCountColumns(columnlocator)};
        return size;
    }

    @Test
    public void tableSizeTest1(){
        int [] expectedSize = {5,6};
        int [] actualSize = getTableSize();
        Assert.assertEquals(actualSize,expectedSize,"table size doesn't match");
    }

    /**
     * Let's write a method that will return table headers as a list.
     *
     * */

    public List<WebElement>getHeaders(){
        return driver.findElements(By.cssSelector("#table1 th"));
    }
    /**
     * this method returns table headers text as a List of Strings
     * @return
     * */
    public List<String> getHeadersText(){
        List<String> headers = new ArrayList<>();
        for(WebElement tableHeader : getHeaders()){
            headers.add(tableHeader.getText());
        }
        return headers;
    }

    @Test
    public void getHeadersTest(){
        List<String> expectedColumnNames = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        Assert.assertEquals(getHeadersText(), expectedColumnNames, "Column names don't match");
    }

    // let's write a test
    //to verify if first name column is sorted alphabetic order

    @Test
    public void sortColumnTest(){
        String columnName = "First Name";
        driver.findElement(By.xpath("//table[1]//th//span[text()='"+columnName+"']")).click();
        List<String> sorted = new ArrayList<>();
        sorted.addAll(getColumnData(columnName));
        Collections.sort(sorted);
        System.out.println(sorted);
        Assert.assertEquals(getColumnData(columnName), sorted);

        //System.out.println(getColumnData("Email"));

    }

    public List<String> getColumnData(String columnName){
        int columnNumber = 0;
        for(int i = 0; i < getCountColumns();i++){
            if(columnName.equals(getHeadersText().get(i))){
                columnNumber = i+1;

            }
        }
        String locatorForColumn = "//table[1]//tbody//tr//td["+columnNumber+"]";

        //this is a collection of webElements that contains value from specific column
        List<WebElement> columnCollectionOfWebElements = driver.findElements(By.xpath(locatorForColumn));
        List<String> columnCollectionOfText = new ArrayList<>();
        for(WebElement element : columnCollectionOfWebElements){
            columnCollectionOfText.add(element.getText());

        }
        return columnCollectionOfText;

    }
}
