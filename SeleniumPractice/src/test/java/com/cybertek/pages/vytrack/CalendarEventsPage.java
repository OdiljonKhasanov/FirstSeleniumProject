package com.cybertek.pages.vytrack;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class CalendarEventsPage {
    private WebDriver driver = Driver.getDriver();
    public String createCalendarEventBtnLocator = "a[title^='Create Calendar']";
    public String repeatCheckBoxLocator = "input[id^='recurrence-repeat-view']";
    public String repeatsDropdowsLocator = "select[id^='recurrence-repeats-view']";

    public List<String> getRepeatOptions(){
        Select select = new Select(driver.findElement(By.cssSelector(repeatsDropdowsLocator)));
        List<WebElement> options = select.getOptions();
        List<String> optionsTextList = new ArrayList<>();
        for(WebElement option : options){
            optionsTextList.add(option.getText());
        }
        return optionsTextList;


    }


}
