package com.learning.concurrencyisweird.eventloop;

import java.util.Queue;

public class WorkerThread extends Thread {
    volatile Queue<Runnable> taskQueue = null;
    Runnable currentTask = null;
    volatile boolean acceptingTask = true;

    WorkerThread(Queue<Runnable> taskQueue){
        this.taskQueue = taskQueue;
    }
    public void run() {
        while(acceptingTask || taskQueue.size()>0) {
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }
                }
                currentTask = taskQueue.poll();
                taskQueue.notifyAll();
            }
            currentTask.run();
        }
    }

    public void stopAccepting() {
        acceptingTask = false;
    }
}
