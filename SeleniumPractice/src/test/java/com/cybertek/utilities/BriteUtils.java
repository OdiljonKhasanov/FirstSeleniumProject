package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BriteUtils {

    WebDriver driver = Driver.getDriver();
    String actionButtonLocator = "//button[contains(text(),'Action')]";
    String okLocator = "//span[text()='Ok']";

    WebDriverWait wait = new WebDriverWait(driver, 10);

    /**
     * Select opportunity based on opportunity title
     * @param opportunity
     */
    public void selectOpportunity(String opportunity){
        String locator = "//td[text()='"+opportunity+"']/preceding-sibling::td//input";
        driver.findElement(By.xpath(locator)).click();
    }

    /**
     * Method that deletes opportunity based on opportunity title
     * @param opportunity
     */
    public void deleteOpportunity(String opportunity){
        selectOpportunity(opportunity);
        selectAction("Delete");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(okLocator)));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(okLocator))));
        driver.findElement(By.xpath(okLocator)).click();
    }

    /**
     * Method that selects action for opportunity
     * @param actionName
     */
    public void selectAction(String actionName){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(actionButtonLocator))));
        driver.findElement(By.xpath(actionButtonLocator)).click();
        String optionLocator = "//a[contains(@data-section,'other') and contains(text(),'"+actionName+"')]";
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(optionLocator))));
        driver.findElement(By.xpath(optionLocator)).click();
    }

    /**
     * Based on opportunity title this method will verify that there is no cell with a given text
     * @param opportunity
     */
    public void verifyThatOpportunityDeleted(String opportunity){
        String locator = "//td[text()='"+opportunity+"']";
        List<WebElement> elements = driver.findElements(By.xpath(locator));
        Assert.assertTrue(elements.isEmpty());
    }
    /**
 * //label[text()='Customer']/../following-sibling::td//input
 * /.. - go to parent element.
 * In this case, from label to <td> and then jump to the following <td> with child <input>*/

//label[text()='Priority']/../following-sibling::td//a[@title='Very High']

    //label[text()='Customer']/../following-sibling::td//input
}
