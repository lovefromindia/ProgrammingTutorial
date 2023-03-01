package com.learning.practicing;

public class LearningWeirdQuestion8 {
    //read notes at last pages of motadata diary
    public void m1(int f){

        StringBuilder s = new StringBuilder("h");

        StringBuilder t = new StringBuilder("u");

//        s += t;
        System.out.println("int");


    }

    public void m1(Float f){

        System.out.println("Float");

    }

    public void m1(double f){

        System.out.println("double");

    }

    public void m1(float... f){

        System.out.println("double");

    }

    public static void main(String[] args) {

        LearningWeirdQuestion8 obj = new LearningWeirdQuestion8();

        obj.m1(10.f);

        System.out.println(new String("AB").hashCode());

    }

}
