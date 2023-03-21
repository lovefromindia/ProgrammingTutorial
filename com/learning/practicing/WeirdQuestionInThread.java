package com.learning.practicing;

import java.util.Arrays;

class A_ extends Thread{
    public void run(){
        System.out.println("Hello");
    }

}


public class WeirdQuestionInThread {
    public void check(A_ a){
        a.start();
        System.out.println(Arrays.toString(a.getClass().getMethods()));
    }

    public static void main(String[] args) {
        WeirdQuestionInThread t = new WeirdQuestionInThread();
        A_ t1 = new A_();
        t.check(t1);//this is instance of A_ class
        System.out.println(t1.getState());
        System.out.println(t1.isAlive());
        
        //below is instance of anonymous class extending A_ class
        //and so we can add new methods in this and could call A_'s
        //class methods also
        t.check(new A_(){
            void method1(){
                System.out.println("hello");
            }
        });
    }
}
