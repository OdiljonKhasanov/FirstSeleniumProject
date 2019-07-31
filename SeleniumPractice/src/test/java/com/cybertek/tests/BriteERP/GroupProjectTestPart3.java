package com.cybertek.tests.BriteERP;

import com.cybertek.pages.BriteERP.LoginPages.BriteLogin;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.SeleniumUtils;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class GroupProjectTestPart3 extends TestBase {

    WebDriver driver = Driver.getDriver();

    /**
     *
     * String logingCssLocator = "[type='submit']";
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
     String tbodyRowsCssLocator = "table tbody tr";*/

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

    @FindBy(xpath = "//table//tbody//tr[2]//td[9] ")
    @CacheLookup
    public WebElement secondRevenueList;

    @FindBy(xpath = "//table//tbody//tr[2]//td[1]")
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

   @Test
   public void/*double*/ secondRevenueFromList(){

       loginPage();
       SeleniumUtils.waitPlease(4);

       CRMButton.click();
       SeleniumUtils.waitPlease(4);
       listButton.click();
       String SecondRevenue = secondRevenueList.getText();
       System.out.println(SecondRevenue);

       Double revenue = Double.valueOf(SecondRevenue);
       System.out.println( revenue + 5);
       //return revenue;

   }

   @Test
   public void secondRevenueFromPivot(){
       loginPage();
       CRMButton.click();
       pivotButton.click();
       newButtonInPivotTable.click();
       OpportunityButtonInPivotTable.click();
       SeleniumUtils.waitPlease(6);

   }

}
