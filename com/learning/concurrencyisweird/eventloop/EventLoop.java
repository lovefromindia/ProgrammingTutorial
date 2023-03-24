package com.learning.concurrencyisweird.eventloop;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// should behave same as ExecutorService
public class EventLoop {

    //holds runnable task which users submits
    //users has no interaction with threads directly and use submit() to submit task
    volatile Queue<Runnable> taskQueue = null;

    //holds the actual limited number of workerThreads which do the work by
    //taking task from taskQueue
    ArrayList<WorkerThread> workerThreads;

    public EventLoop(int size){
        taskQueue = new LinkedList<>();
        workerThreads = new ArrayList<>();
        for(int i = 0;i < size;i++){
            workerThreads.add(new WorkerThread(taskQueue));
        }

        //starts running the workerThreads
        for(int i = 0;i < size;i++){
            workerThreads.get(i).start();
        }
    }


    //user interacts with this method
    //taskQueue is synchronized so that any workerThread don't access it
    //during addition of new task
    public void submit(Runnable task){
        synchronized (taskQueue) {
            taskQueue.offer(task);
            taskQueue.notifyAll();
        }
    }

    //should behave same executorservice.shutdown()
    public void shutdown(){
        for (WorkerThread w :
                workerThreads) {
            w.stopAccepting();
        }
    }

}
