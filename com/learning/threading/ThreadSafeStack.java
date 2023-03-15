package com.learning.threading;

public class ThreadSafeStack {

    Integer stackTop = Integer.valueOf(-1);
    int container[];
    Object lock = new Object();

    ThreadSafeStack(int n){
        container = new int[n];
    }

    //if t1 acquires lock then t2 will not be able to acquire
    //it in pop() method hence would not able to modify the stackTop
    boolean push(int ele){
        synchronized (lock){
            if(isFull()){
                return false;
            }
            ++stackTop;
            System.out.println(Thread.currentThread() + " " + stackTop);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread() + " " + stackTop);
            container[stackTop] = ele;
            return true;
        }
    }

    int pop(){
        synchronized (lock) {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return container[stackTop--];
        }
    }

    boolean isFull(){
        return stackTop == container.length-1;
    }

    void method(){
        synchronized (this){
            System.out.println("Inside another synchronized method");
        }
    }

    boolean isEmpty(){
        return stackTop < 0;
    }

    public static void main(String[] args) {
        ThreadSafeStack threadSafeStack = new ThreadSafeStack(5);
        Thread t1 = new Thread(()->{
            threadSafeStack.push(1);
            threadSafeStack.push(2);
        });
        Thread t2 = new Thread(()->{
            System.out.println(threadSafeStack.pop());
        });

        t1.start();
        t2.start();
    }
}
