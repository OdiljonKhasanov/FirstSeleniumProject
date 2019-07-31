package com.cybertek.pages.BriteERP.LoginPages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BriteLogin {

    private WebDriver driver = Driver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(id = "login")
    @CacheLookup
    public WebElement emailInputBox;

    @FindBy(id = "password")
    @CacheLookup
    public WebElement passwordInputBox;

    @FindBy(css = "[type='submit']")
    @CacheLookup
    public WebElement loginButton;

    public BriteLogin(){
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password){
        emailInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }

}
