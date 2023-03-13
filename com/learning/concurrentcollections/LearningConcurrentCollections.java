package com.learning.concurrentcollections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LearningConcurrentCollections {
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(1);

        try {

            System.out.println(blockingQueue.offer(4,1,TimeUnit.SECONDS));

            System.out.println(blockingQueue.offer(4,1, TimeUnit.SECONDS));

            System.out.println(blockingQueue.poll());

            System.out.println(blockingQueue.offer(4,1, TimeUnit.SECONDS));

        }catch (Exception e){

            System.out.println(e.getMessage());

        }

        System.out.println(blockingQueue);

        blockingQueue = new ArrayBlockingQueue<>(4);

        try {

            System.out.println(blockingQueue.offer(4,1,TimeUnit.SECONDS));

            System.out.println(blockingQueue.offer(5,1, TimeUnit.SECONDS));

            System.out.println(blockingQueue.offer(6,1, TimeUnit.SECONDS));

            System.out.println(blockingQueue.poll());

            System.out.println(blockingQueue.offer(7,1, TimeUnit.SECONDS));

            System.out.println(blockingQueue.offer(8,1, TimeUnit.SECONDS));

        }catch (Exception e){

            System.out.println(e.getMessage());

        }

        System.out.println(blockingQueue);


    }

}
