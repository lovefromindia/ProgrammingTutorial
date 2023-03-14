package com.learning.threading;

public class MakingDaemonThread {

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{

            try {

                System.out.println(Thread.currentThread());

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                throw new RuntimeException(e);

            }

            System.out.println("Hello World in Daemon Thread");

        }, "Daemon Thread");

        //if we set t1 as Daemon thread then after executing main thread
        //no user threads are left so jre will not wait for daemon
        //thread to exit and will stop running. So "Completed Loop"
        //may/may not be printed
        //try commenting below line then t1 becomes user thread
        //and jre will wait for t1 to complete the execution
//        t1.setDaemon(true);

        t1.start();

        System.out.println("Hello World in Main Thread");

    }

}
