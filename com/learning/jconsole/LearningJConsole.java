package com.learning.jconsole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LearningJConsole {
    static Object obj1 = new Object();
    static Object obj2 = new Object();
    static void method1(){
        synchronized (obj1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (obj2){}
        }
    }

    static void method2(){
        synchronized (obj2){synchronized (obj1){}}
    }
    public static void main(String[] args) {
        new Thread(()->method1()).start();
        new Thread(()->method2()).start();
    }
}
