package com.cybertek.tests.Day14;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class SystemPropertiesTets {


    @Test
    public void systemPropertiesTest1(){
        String os = System.getProperty("os.name");
        String username = System.getProperty("user.name");
        String javaVersion = System.getProperty("java.specification.version");
        String homeDirectory = System.getProperty("user.home");
        System.out.println(os);
        System.out.println(username);
        System.out.println(javaVersion);
        System.out.println(homeDirectory);

        Properties properties = System.getProperties();
        for(Map.Entry<Object, Object> property: properties.entrySet()){
            System.out.println("Key: " + property.getKey()+", Value: " + property.getValue());
        }


    }
}
