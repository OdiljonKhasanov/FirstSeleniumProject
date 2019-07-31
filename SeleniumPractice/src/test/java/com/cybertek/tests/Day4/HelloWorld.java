package com.cybertek.tests.Day4;

import com.github.javafaker.Faker;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());

        System.out.println(faker.name().lastName());
        System.out.println(faker.chuckNorris().fact());


    }
}
