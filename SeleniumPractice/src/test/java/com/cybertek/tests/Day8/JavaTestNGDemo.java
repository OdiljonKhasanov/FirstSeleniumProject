package com.cybertek.tests.Day8;

import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaTestNGDemo {

    @Test
    public void test1(){
        String a = "A";
        String b = "A";
        Assert.assertEquals(a, b);
    }

    @Test
    public void test2(){
        String str1 = "Apple";
        String str2 = "Orange";
        Assert.assertEquals(str1, str2);
    }

    @Test
    public void test3(){
        String str1 = "ADAF";
        String str2 = "AAA";
        //Assert.assertTrue(str1.equals(str2));
        Verify.verify(str1.equals(str2));

    }

    @Test
    public void test4(){
        Assert.assertFalse(false);
    }
}
