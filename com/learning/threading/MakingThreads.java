package com.learning.threading;

class UThread extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {

            System.out.println("in user thread from extends" + Thread.currentThread());

        }

    }

}

public class MakingThreads {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {

                System.out.println("in thread from runnable" + Thread.currentThread());

                try {

                    Thread.sleep(10000);

                } catch (InterruptedException e) {

                    throw new RuntimeException(e);

                }

            }

        };

        System.out.println("In Main Thread" + Thread.currentThread());

        Thread t = new Thread(r1);

        t.start();

        //reusing runnable object with other thread
//        t = new Thread(r1);
//
//        t.start();
//
//        System.out.println(Thread.activeCount());
//
//        new Thread(() -> {
//
//            System.out.println("In Runnable lambda" + Thread.currentThread());
//
//        }).start();
//
//        t = new UThread();
//
//        t.start();

    }

}
