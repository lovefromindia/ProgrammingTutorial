package com.learning.threading;

import java.util.Scanner;


public class ThreadStates implements Runnable{

    public static void main(String[] args) {

//        ThreadStates t1 = new ThreadStates();
//        t1.start();


        Thread t1 = new Thread(()->{

            for(int i = 0;i < 10000000;i++);

            try {

                Thread.sleep(100);

            } catch (InterruptedException e) {

                throw new RuntimeException(e);

            }

            Scanner s = new Scanner(System.in);

            s.nextLine();

        });

        t1.start();

        while(true){

            Thread.State state = t1.getState();
            System.out.println(state);

            if(state == Thread.State.TERMINATED)break;

        }

    }

    @Override
    public void run() {

    }
}
