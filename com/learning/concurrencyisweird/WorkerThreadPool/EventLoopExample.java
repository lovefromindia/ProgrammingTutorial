package com.learning.concurrencyisweird.WorkerThreadPool;

public class EventLoopExample {

    public static void main(String[] args) {

        WorkerThreadPool eventLoop = new WorkerThreadPool(4);
        for(int i = 0;i < 10;i++){
            int a = i;
            eventLoop.submit(()->{
                try {
                    Thread.sleep(1000);
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
                System.out.println("Doing work by Thread "+a);
            });
            eventLoop.shutdown();
        }
    }

}
