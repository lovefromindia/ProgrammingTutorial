package com.learning.concurrencyisweird.eventloop;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// should behave same as ExecutorService
public class ThreadPool {

    //firstTask is used to know when to lazily initialize all the worker thread
    //WorkerThreads are only initialized when any task is submitted
    private volatile boolean firstTask;

    private final int MAX_THREADS;

    //holds runnable task which users submits
    //users has no interaction with threads directly and use submit() to submit task
    volatile Queue<Runnable> taskQueue = null;

    //holds the actual limited number of workerThreads which do the work by
    //taking task from taskQueue
    ArrayList<WorkerThread> workerThreads = null;

    public EventLoop(int size){
        taskQueue = new LinkedList<>();
        workerThreads = new ArrayList<>();
        firstTask = true;
        MAX_THREADS = size;
    }


    //user interacts with this method
    //taskQueue is synchronized so that any workerThread don't access it
    //during addition of new task
    public void submit(Runnable task){

        synchronized (taskQueue) {
            taskQueue.offer(task);
            taskQueue.notifyAll();

            //lazy initialization of all the worker threads when first task is submitted
            if(firstTask) {
                System.out.println("Lazily woke up");

                for(int i = 0;i < this.MAX_THREADS;i++){
                    workerThreads.add(new WorkerThread(taskQueue));
                }

                //starts running the workerThreads
                for (int i = 0; i < workerThreads.size(); i++) {
                    workerThreads.get(i).start();
                }

                //turning off so that only one time WorkerThreads are created :)
                firstTask = false;
            }
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
