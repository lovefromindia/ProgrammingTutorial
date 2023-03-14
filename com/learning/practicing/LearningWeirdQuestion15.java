package com.learning.practicing;

import java.util.Arrays;

class CacheCoherence {
    static int counter = 0;

    static synchronized int increment(){
        counter++;
        return counter;
    }

    static synchronized int getCounter(){
        return counter;
    }

    public static void main() {
        Thread t1 = new Thread(() -> {
            int localCounter = 0;
            while (localCounter < 10) {
                if (localCounter != getCounter()) {
                    System.out.println("Thread 1 read value " + getCounter());
                    localCounter = getCounter();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            int localCounter = 0;
            while (localCounter < 10) {
                localCounter = increment();
                System.out.println("Thread 2 Modified the counter value to " + getCounter());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}

public class LearningWeirdQuestion15 {

    public static void main(String[] args) {

        CacheCoherence.main();

    }

}
