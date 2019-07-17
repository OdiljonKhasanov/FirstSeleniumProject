package com.cybertek.Day2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.getDriver("chrome");

        int counter = 0;
        List<String> titles = new ArrayList<>();
        List<String>actualURLs = new ArrayList<>();//list where i am going to store page URLs

        for (int i = 0; i < urls.size(); i++){
            driver.get(urls.get(i));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            titles.add(driver.getTitle());//I am adding page title into list , for every website
            actualURLs.add(driver.getCurrentUrl());
        }

        String expectedTitles = "Practice";
        String expectedURl = "http://practice.cybertekschool.com";
        for(String title: titles){
            System.out.println("Verify system page");
            if(title.equals(expectedTitles)){

                System.out.println("Passed");
            }else{
                System.out.println("Failed");
                System.out.println("Expected: " + expectedTitles);
                System.out.println("Actual title: " + title);
            }

            System.out.println("Verify page URLs");
            if(driver.getCurrentUrl().startsWith(expectedURl)){
                System.out.println("URL is correct");
                System.out.println("Passed");

            }else{
                System.out.println("URL is not correct");
                System.out.println("Failed");
            }
        }


    }


}
