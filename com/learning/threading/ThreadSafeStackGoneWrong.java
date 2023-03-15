package com.learning.threading;

    public class ThreadSafeStackGoneWrong {

        Integer stackTop = Integer.valueOf(-1);
        int container[];
        Object lock = new Object();

        ThreadSafeStackGoneWrong(int n){
            container = new int[n];
        }

        //if t1 acquires lock then t2 will not be able to acquire
        //it in pop() method hence would not able to modify the stackTop
        boolean push(int ele){
            synchronized (stackTop){
                if(isFull()){
                    return false;
                }
                ++stackTop;
                System.out.println(stackTop);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(stackTop);
                container[stackTop] = ele;
                return true;
            }
        }

        int pop(){
            synchronized (stackTop) {
                if (isEmpty()) {
                    return Integer.MIN_VALUE;
                }
                return container[stackTop--];
            }
        }

        boolean isFull(){
            return stackTop == container.length-1;
        }

        boolean isEmpty(){
            return stackTop < 0;
        }

        public static void main(String[] args) {
            ThreadSafeStackGoneWrong threadSafeStackGoneWrong = new ThreadSafeStackGoneWrong(5);
            Thread t1 = new Thread(()->{
                threadSafeStackGoneWrong.push(1);
                threadSafeStackGoneWrong.push(2);
            });
            Thread t2 = new Thread(()->{
                System.out.println(threadSafeStackGoneWrong.pop());
            });

            t1.start();
            t2.start();
        }
    }
