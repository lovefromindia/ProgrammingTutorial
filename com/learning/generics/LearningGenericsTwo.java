package com.learning.generics;

import java.io.Serializable;

class Foo<T extends Object & Serializable & Runnable, V extends Integer>{}

//class A{
//    private void method1(){}
//}
//class B extends A{
//    protected void method1(){}
//}
public class LearningGenericsTwo {

    public static void main(String[] args) {
        String name1 = "Mihir";
        String name2 = "MihirAgrawal";
        name1 += "Agrawal";// name1 = name1.concat(name2).toString()
        name1.concat("");
        System.out.println(name1 == name2);
        final String s1 = "Hello";
        final String s2 = "Chandu";
        String s3 = "HelloChandu";
        String s4 = s1+s2;
        System.out.println(s4 == s3);

        try{

            int i = 0;

            System.out.println("Hello " + " " + (20-2));

        }catch (Exception e){

            System.out.println(e.getMessage());

        }

    }

}
