package com.learning.threading;
//FUNCTIONING OF BLOCKINGQUEUE:
//this queue would have fixed size so fixed amount of items can be added in it
//if producer thread tries to push item when queue is full then that thread
//will be blocked until some item is removed and space is created
//Also if consumer thread tries to popFront from empty queue then
//consumer thread will be blocked until producer thread adds item

import java.util.LinkedList;
import java.util.Queue;

public class UBlockingQueue {

    private Queue<Integer> container;
    private int maxSize = 0;

    UBlockingQueue(int n){
        container = new LinkedList<>();
        maxSize = Integer.max(n,1);
    }

    boolean offer(int ele){
        synchronized (container) {
            System.out.println("Offer has container lock " + Thread.currentThread());
            while(container.size() == maxSize){
                try {
                    container.wait();
                } catch (InterruptedException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            container.offer(ele);
            container.notifyAll();
            return true;
        }
    }

    Integer poll(){
        synchronized (container) {
            System.out.println("Poll has container lock " + Thread.currentThread());
            while(container.size() == 0){
                try {
                    container.wait();
                } catch (InterruptedException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            Integer ele = container.poll();
            container.notifyAll();
            return ele;
        }
    }

    @Override
    public String toString() {
        return "UBlockingQueue{" +
                "container=" + container +
                ", maxSize=" + maxSize +
                '}';
    }

    public static void main(String[] args) {

        UBlockingQueue uBlockingQueue = new UBlockingQueue(5);

        new Thread(()->{
            uBlockingQueue.poll();
        },"Consumer").start();
        new Thread(()->{
            uBlockingQueue.offer(10);
        },"Producer").start();
        System.out.println(uBlockingQueue);
    }

}
