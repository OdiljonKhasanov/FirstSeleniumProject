package com.cybertek.tests.BriteERP;

import com.cybertek.pages.BriteERP.LoginPages.BriteLogin;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GroupProjectTestPart3 extends TestBase {

    WebDriver driver = Driver.getDriver();

  

    public GroupProjectTestPart3(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[data-menu-xmlid='crm.crm_menu_root'] span[class='oe_menu_text']")
    @CacheLookup
    public WebElement CRMButton;

    @FindBy(xpath = "//button[@data-original-title='List']")
    @CacheLookup
    public WebElement listButton;

    @FindBy(xpath = "//button[@data-original-title='Pivot']")
    @CacheLookup
    public WebElement pivotButton;

    @FindBy(xpath = "//table//tbody//tr//td[9]")
    @CacheLookup
    public List<WebElement> RevenuesFromList;

    @FindBy(xpath = "//tr/td[2]")
    @CacheLookup
    public List<WebElement> RevenuesFromPivot;

    @FindBy(xpath = "//tr[1]/td[2]")
    @CacheLookup
    public static WebElement TotalRevenueFromPivot;

    @FindBy(xpath = "//table//tbody//tr[2]//td[9] ")
    @CacheLookup
    public WebElement secondRevenueList;

    @FindBy(xpath = "//table//tbody//tr[2]//td[3]")
    public WebElement secondOpportunityList;


    @FindBy(css = "[data-original-title='Stage']")/*(xpath = "//table//tbody//tr[2]//td[1]")*/
    @CacheLookup
    public WebElement newButtonInPivotTable;

    @FindBy(linkText = "Opportunity")
    public WebElement OpportunityButtonInPivotTable;



   public void loginPage(){
        BriteLogin login = new BriteLogin();
        String email  = ConfigurationReader.getProperty("eventscrmmanagerEmail");
        String password = ConfigurationReader.getProperty("eventscrmmanagerPassword");
        login.login(email,password);

   }


   /**
    * Acceptance Criteria:
    *
    * 1.Verify that second opportunity’ Expected Revenue value on the Pivot board should be the same
    * as the Expected revenue column value on the list board.
    * */

   @Test()
   public void/*double*/ secondRevenuesFromListAndPivot(){

       loginPage();
       SeleniumUtils.waitPlease(1);

       CRMButton.click();
       SeleniumUtils.waitPlease(1);

       //list view part
       listButton.click();
       SeleniumUtils.waitPlease(1);

       String SecondRevenue = secondRevenueList.getText();
       Double revenue2FromList = Double.valueOf(SecondRevenue);
       System.out.println( revenue2FromList );

       String OpportunityName = secondOpportunityList.getText();
       System.out.println(OpportunityName);


       //pivot view part
       pivotButton.click();
       SeleniumUtils.waitPlease(1);
       newButtonInPivotTable.click();
       SeleniumUtils.waitPlease(1);
       OpportunityButtonInPivotTable.click();

       String secontRevenueBasedOnNameXpath = "//table//td[text()='"+OpportunityName+"']/following-sibling::td[1]";

       String revenueNumber = driver.findElement(By.xpath(secontRevenueBasedOnNameXpath)).getText();
       Double revenue2FromPivot = Double.valueOf(revenueNumber);
       System.out.println(revenue2FromPivot);

       Assert.assertEquals(revenue2FromList,revenue2FromPivot);


   }

   /**
    * Acceptance Criteria:
    *  2. Verify that on the pivot table,
    *  the total expected revenue should be the sumof all opportunities’ expected revenue.
    *
    *  */

   @Test
   public void TotalRevenuesFromPivot(){

       loginPage();
       //SeleniumUtils.waitPlease(1);
       CRMButton.click();
       //SeleniumUtils.waitPlease(1);
       pivotButton.click();
      // SeleniumUtils.waitPlease(1);
       newButtonInPivotTable.click();
       //SeleniumUtils.waitPlease(1);
       OpportunityButtonInPivotTable.click();
       SeleniumUtils.waitPlease(1);

       List<Double> revenues = new ArrayList<>();
       for (int i =2;i<RevenuesFromPivot.size(); i++){

           //System.out.println(RevenuesFromPivot.get(i).getText());
           revenues.add(Double.valueOf(RevenuesFromPivot.get(i).getText()));

       }

       double manualCountedRevenue = 0;

       for(int i =0; i< revenues.size();i++){

           manualCountedRevenue +=revenues.get(i);
       }

       String lessPrecise = String.format("%.5g%n", manualCountedRevenue);
       System.out.println(lessPrecise);

       Double ExpectedTotalRevenue = Double.valueOf(lessPrecise);
       Double ActualTotalRevenue = Double.valueOf(TotalRevenueFromPivot.getText());
       System.out.println("Expected Total counted manually: " + ExpectedTotalRevenue);
       System.out.println("Actual Total displayed on Application: " + ActualTotalRevenue);
       Assert.assertEquals(ExpectedTotalRevenue,ActualTotalRevenue);

   }

   /*@Test(priority = 2)
   public void secondOpportunityNameFromList(){
       loginPage();
       CRMButton.click();
       listButton.click();
       String OpportunityName = secondOpportunityList.getText();
       System.out.println(OpportunityName);
       secondOpportunityString = OpportunityName;
   }

   @Test(priority = 3)
   public void getListResults(){
       //System.out.println("2 Opportunity: " + secondOpportunityNameFromList() + "/n 2R evenue: " + secondRevenueFromList());


       System.out.println(secondRevenueDouble);
       System.out.println(secondOpportunityString);

   }


   @Test
   public void secondRevenueFromPivot(){
       loginPage();
       CRMButton.click();
       pivotButton.click();
       newButtonInPivotTable.click();
       OpportunityButtonInPivotTable.click();
       //SeleniumUtils.waitPlease(6);

       for (int i =2;i<RevenuesFromPivot.size(); i++){

           System.out.println(RevenuesFromPivot.get(i).getText());
       }

   }*/

}
