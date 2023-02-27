package com.learning.practicing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class LearningWeirdQuestion7 {


//    ***Below will give compilation error of InitializerError
//    static int x[];
//
//    static {
//        x[0] = 1;
//    }

//    ***Below will give error as final static member has to be initialized
//    static final int i;
//    LearningWeirdQuestion7(){
//        i = 0;
//    }
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Human h = new Human_();
        System.out.println(Arrays.toString(h.getClass().getDeclaredFields()));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Human{

    Human(){
        System.out.println("con");
    }
    private int age;
    private byte ch;

    private void method(){}
    public void method1(){}

}

class Human_ extends Human{

}
