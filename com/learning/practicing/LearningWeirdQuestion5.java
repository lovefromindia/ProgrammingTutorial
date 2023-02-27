package com.learning.practicing;

import java.io.IOException;

class A{
    public void method1() throws IOException{}

    public void method2(){}

    public void method3(){}

    public void method4() throws RuntimeException{}

}

class B extends A{
    public void method1() {}

//    ***Below code shows error
//    @Override
//    public void method2() throws IOException{}


    @Override
    public void method3() throws NumberFormatException{}

//    ***Below will give error as Exception is not subclass of RuntimeException
//    @Override
//    public void method4() throws Exception {}

    //Below works fine as NumberFormatException is subclass of RuntimeException
    @Override
    public void method4() throws NumberFormatException{}

}

public class LearningWeirdQuestion5 {

    public static void main(String... args) {

        System.out.println(new A());

        final Student s = new Student(10);

        final int i;

        i = 0;

        s.roll = 20;

        System.out.println(s.roll);

//        s = null;

    }

}

class Student{
    public int roll;

    Student(int r){
        roll = r;
    }
}
