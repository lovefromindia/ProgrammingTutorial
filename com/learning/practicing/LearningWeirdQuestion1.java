package com.learning.practicing;

class Test1{

    static {

        System.out.println("static");

    }

    {

        System.out.println("Instance");

    }
    public void Test1(){

        System.out.println("Am i the constructor? NO NO");

    }

}
public class LearningWeirdQuestion1 {

    public static void main(String[] args) {

        Test1 t = new Test1();

    }

}