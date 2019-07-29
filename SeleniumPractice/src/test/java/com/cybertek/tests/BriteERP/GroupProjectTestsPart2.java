package com.cybertek.tests.BriteERP;

import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupProjectTestsPart2  {

    WebDriver driver;
    String logingCssLocator = "[type='submit']";
    String crmCssLocator = "a[data-menu-xmlid='crm.crm_menu_root'] span[class='oe_menu_text']";
    String pageNameXpathLocator = "//li[text()='Pipeline']";
    String listButtonXpathLocator = "//button[@data-original-title='List']";
    String tableCssLocator = "[class='o_list_view table table-condensed table-striped o_list_view_ungrouped']";
    String createCssLocator = "[class='btn btn-primary btn-sm o_list_button_add']";
    String nameFieldCssLocator = "[id^=o_field_input_]";
    String saveButtonCssLocator = "[class='btn btn-primary btn-sm o_form_button_save']";
    String itemPagenameCssLocator = "[class='breadcrumb']";
    String checkBoxXpathLocator = "//table/tbody//input";
    String actionButtonXpathLocator = "//button[contains(text(),'Action')]";
    String deleteXpathLocator = "//a[contains(text(),'Delete')]";
    String okButtonCssLocator = " button.btn.btn-sm.btn-primary > span";
    String tbodyRowsCssLocator = "table tbody tr";



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login")).sendKeys("eventscrmmanager11@info.com");
        driver.findElement(By.id("password")).sendKeys("eventscrmmanager");
        driver.findElement(By.cssSelector(logingCssLocator)).click();


    }


    public void seeListView(){
        driver.findElement(By.cssSelector(crmCssLocator)).click();
        String pagename = driver.findElement(By.xpath(pageNameXpathLocator)).getText();
        Assert.assertEquals(pagename, "Pipeline");
        driver.findElement(By.xpath(listButtonXpathLocator)).click();
        WebElement table = driver.findElement(By.cssSelector(tableCssLocator));
        Assert.assertTrue(table.isDisplayed());

    }

    @Test
    public void createOppotunity(){
        seeListView();
        driver.findElement(By.cssSelector(createCssLocator)).click();
        Faker faker = new Faker();
        String item = faker.funnyName().name();
        driver.findElement(By.cssSelector(nameFieldCssLocator)).sendKeys(item);
        driver.findElement(By.cssSelector(saveButtonCssLocator)).click();
        SeleniumUtils.waitPlease(2);
        String itemNamePage = driver.findElement(By.cssSelector(itemPagenameCssLocator)).getText();
        Assert.assertTrue(itemNamePage.contains(item));
        System.out.println(item);
        System.out.println(itemNamePage);

    }

    @Test
    public void deleteOpportunity(){
        seeListView();

        //createOppotunity();
        SeleniumUtils.waitPlease(1);
        //driver.navigate().back();

       List<WebElement> rows1 = driver.findElements(By.cssSelector(tbodyRowsCssLocator));
       int numOfRowsBefore = rows1.size();

        driver.findElement(By.xpath(checkBoxXpathLocator)).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(actionButtonXpathLocator)).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.xpath(deleteXpathLocator)).click();
        SeleniumUtils.waitPlease(1);
        driver.findElement(By.cssSelector(okButtonCssLocator)).click();

        SeleniumUtils.waitPlease(3);
        List<WebElement> rows2 = driver.findElements(By.cssSelector(tbodyRowsCssLocator));
        driver.navigate().refresh();
        int numOfRowsAfter = rows2.size();

        System.out.println("rows before: " + numOfRowsBefore + ", rows after: "+ numOfRowsAfter);
        Assert.assertTrue(numOfRowsBefore > numOfRowsAfter);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
