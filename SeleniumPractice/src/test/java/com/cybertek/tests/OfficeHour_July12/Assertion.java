package com.cybertek.tests.OfficeHour_July12;

import static org.testng.Assert.*;  // this step imports all the static features from the assert class
import org.testng.annotations.Test;

public class Assertion {
/*
    Assertion class:
            used to verify the condition of the test cases

            assertTrue( boolean ):  argument must be true boolean expression, or else the remaining test steps won't be executed
            assertFalse( boolean ); argument must be false boolean expression
            assertEquals( variable1, variable2); arguments MUSt be equal
            assertNotEquals(): arguments can be equal

            they are static methods. they can be called through classname
            import static  of Assert class will import all the static features from the Assert class


     */

    @Test
    public  void method1(){
        assertTrue(1==1);
        System.out.println("Test 1 completed");
    }

    @Test
    public void method2(){
        assertFalse(1 > 2);
        System.out.println("Test 2 completed");
    }

    @Test
    public void method3(){
        assertEquals(1,1);
        System.out.println("Test 3 completed");
    }

    @Test
    public void method4(){
        assertNotEquals("Batch 11", "Best Batch");
    }

}
