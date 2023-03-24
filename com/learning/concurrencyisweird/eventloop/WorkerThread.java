package com.learning.concurrencyisweird.eventloop;

import java.util.Queue;

public class WorkerThread extends Thread {

    //volatile so that change is visible
    volatile Queue<Runnable> taskQueue = null;
    volatile boolean acceptingTask = true;
    Runnable currentTask = null;


    //locks on the taskQueue in the EventLoop
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

            //this is outside synchronized block so that
            //other workerThreads don't have to wait for
            //this thread (for acquiring lock on taskQueue)
            // to run the task and can run next task in the queue (if any)
            currentTask.run();
        }
    }

    public void stopAccepting() {
        acceptingTask = false;
    }
}
