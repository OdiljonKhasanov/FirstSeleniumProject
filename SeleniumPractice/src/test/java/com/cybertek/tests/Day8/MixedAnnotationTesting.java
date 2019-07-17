package com.cybertek.tests.Day8;

import org.testng.annotations.*;

public class MixedAnnotationTesting {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Before method");
    }

    @Test
    public void test1(){
        System.out.println("Test1");
    }

    @Test
    public void test2(){
        System.out.println("Test 2");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

}
