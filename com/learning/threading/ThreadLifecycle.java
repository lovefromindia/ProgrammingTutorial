package com.learning.threading;

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("My thread, My rules");
    }
}
public class ThreadLifecycle {

    public static void main(String[] args) {

        Thread t1 = new Thread("mythread");
        new MyThread().start();
        Thread t = new Thread(()->{
            System.out.println("I have started...");
            System.out.println("I have ended...");
        });
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Thread 't' is dead by now but still we can use its methods
        //why? because java Thread class is just wrapper for the native thread
        //Underlying native thread exits and the 't' no longer holds the native
        //thread but as in java we still hold reference to 't' object, so we
        //can call some of its method like interrupt() which sets the interruptFlag
        //inside Thread object and getState() method which would
        //always return TERMINATED
        //but if we try to call method start(), its illegal as native thread
        //is already lost so it throws exception
        t.interrupt();
        System.out.println(t.isInterrupted());
        System.out.println(t.getState());
        try {
            t.join();
            t.run();
            t.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
