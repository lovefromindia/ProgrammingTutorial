package com.learning.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadingAct1 {

    static int variable = 0;

    public static synchronized void method(){
        for(int i = 0;i < 1000;i++) {
//            try {
//                Thread.sleep(1);
//            }catch(Exception e){
//                System.out.println(e.getMessage());
//            }
            variable += 1;
        }
    }
    public static void main(String[] args) {
//        Runnable t1 = new Runnable(){
//          public void run(){
//              method();
//          }
//        };
//
//        Runnable t2 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//
//        Runnable t3 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//        Runnable t4 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//        Runnable t5 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//        Runnable t6 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//
//        Runnable t7 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//        Runnable t8 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//        Runnable t9 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//        Runnable t10 = new Runnable() {
//            @Override
//            public void run() {
//                method();
//            }
//        };
//
//            t1.run();
//            t2.run();
//            t3.run();
//            t4.run();
//            t5.run();
//            t6.run();
//            t7.run();
//            t8.run();
//            t9.run();
//            t10.run();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0;i < 10;i++) {
            executorService.submit(() -> method());
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("The value of i: " + variable);
    }

}
