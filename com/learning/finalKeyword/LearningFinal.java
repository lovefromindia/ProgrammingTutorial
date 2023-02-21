package com.learning.finalKeyword;
import java.util.Scanner;

public class LearningFinal {

    final static int age = Integer.valueOf(12);

    final static int size = factorial(5);

    final static String name = getName();

    final static StringBuilder str = new StringBuilder("Mihir");

    public static void main(String[] args) {

//        System.out.print("Name: " + name.intern() + (name == "Hello") + " " + age + " " + size);

        System.out.print("Name: " + (name == "Hello") + " " + age + " " + size);

        System.out.println("Hello".getClass());

        System.out.println(str);

        str.append(" L. Agrawal");

        System.out.println(str);

    }

    public static int factorial(int n){

        return n == 0 ? 1: n * factorial(n-1);

    }

    public static String getName(){

        String s1 = "Hel";

        String s2 = "lo";

        return s1 + s2;

    }

}
