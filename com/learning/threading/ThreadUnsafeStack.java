package com.learning.threading;

public class ThreadUnsafeStack {

    int stackTop = -1;
    int container[];

    ThreadUnsafeStack(int n){
        container = new int[n];
    }

    boolean push(int ele){
        if(isFull()){
            return false;
        }
        ++stackTop;
        //putting t1 to sleep to increase the probability that t1 first increase stackTop
        //first then put to sleep. Then other thread t2 will be allowed to run
        //and will pop from the stack i.e. again make stackTop = -1
        //and returns garbage value because stackTop had increased in
        // t1 but no value was pushed because of t1 had gone to sleep.
        // After that t1 will resume and now will goto statement container[stackTop] = ele
        //Now stackTop had increased to 0 earlier by t1 but while t1 was sleeping or
        //it may be case that t1 was context switched and t2 was allowed to run
        //then t2 again changed the value to -1
        //hence the container[stackTop] resolves to container[-1] which
        //will throw ArrayIndexOutOfBoundsException in runtime
        //hence we should share the stackTop variable such that only one can modify/read
        //the value
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        container[stackTop] = ele;
        return true;
    }

    int pop(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return container[stackTop--];
    }

    boolean isFull(){
        return stackTop == container.length-1;
    }

    boolean isEmpty(){
        return stackTop < 0;
    }

    public static void main(String[] args) {
        ThreadUnsafeStack threadUnsafeStack = new ThreadUnsafeStack(5);
        Thread t1 = new Thread(()->{
            threadUnsafeStack.push(1);
            threadUnsafeStack.push(2);
        });
        Thread t2 = new Thread(()->{
            System.out.println(threadUnsafeStack.pop());
        });

        t1.start();
        t2.start();
    }

}
