package com.learning.threading;

public class ThreadParent {

    static void makeThread(){
        new Thread(()->{
            System.out.println(Thread.currentThread());
        },"Thread2").start();
    }
    public static void main(String[] args) {

        new Thread(()->{
            makeThread();
            System.out.println(Thread.currentThread());
        },"Thread1").start();
    }

}
