package com.learning.concurrencyisweird.eventloop;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EventLoop {
    volatile Queue<Runnable> taskQueue = null;
    ArrayList<WorkerThread> workerThreads;

    public EventLoop(int size){
        taskQueue = new LinkedList<>();
        workerThreads = new ArrayList<>();
        for(int i = 0;i < size;i++){
            workerThreads.add(new WorkerThread(taskQueue));
        }
        for(int i = 0;i < size;i++){
            workerThreads.get(i).start();
        }
    }

    public void submit(Runnable task){
        synchronized (taskQueue) {
            taskQueue.offer(task);
            taskQueue.notifyAll();
        }
    }

    public void shutdown(){
        for (WorkerThread w :
                workerThreads) {
            w.stopAccepting();
        }
    }

}
