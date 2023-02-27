package com.learning.practicing;

class Base{
    void method1() throws Exception{

        System.out.println("In parent");

    }

}

class Child extends Base{

    void method1(){

        System.out.println("In child");

    }

}
public class LearningWeirdQuestion9 {

    public static void main(String[] args) {

        Base b = new Child();


//        ***below will give compilation error method1 throws exception
//        b.method1();

    }

}
