package com.learning.generics;


import org.w3c.dom.ls.LSOutput;

class Box<T>{

    void add(T obj){

    }

    public String toString(){

        return "In box";

    }

}

class Car{
    void add(Object obj){

        System.out.println("Object");

    }
    void add(Integer obj){

        System.out.println("Integer");

    }

}

public class LearningGenerics {

    public static void main(String[] args) {

        Number b = Double.valueOf(10);

//    Box<Object> d = new Box<Double>();

        Box<Integer> c = new Box<Integer>();

        c.add(2);

        System.out.println(c.getClass());

//        Box<Object> d = c;
        Box d = c;

        d.add('3');

        System.out.println(c.toString());

        System.out.println(d.toString());

        Car cr = new Car();

        cr.add("String");

        cr.add(3);

    }

}
