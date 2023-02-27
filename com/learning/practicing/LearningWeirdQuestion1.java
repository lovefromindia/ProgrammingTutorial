package com.learning.practicing;

import java.io.BufferedReader;

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

abstract class RR{
    protected abstract void method1();
}

interface I{
    private void method1(){
        System.out.println("in private method");
    }

    // not possible in java to have protected method inside interface
//    protected void method2(){
//        System.out.println("in protected method");
//    }
    int p = 0;

}

class R implements I{

    public static void main(String[] args) {
        System.out.println(R.p);
    }

}