package com.learning.threading;

class NoVisibility {

    private static boolean ready = false;

    private static int number;

    private static class ReaderThread extends Thread {

        public void run() {

            while (!ready) {
                System.out.println("Waiting...");
                Thread.yield();
            }

            System.out.println(number);

        }

    }

    public static void main(String[] args) {

        ReaderThread  r = new ReaderThread();

        r.start();

        number = 42;

        ready = true;

    }

}
public class ThreadingAct2 {

    public static void main(String[] args) {

//        NoVisibility.ReaderThread r;***Because ReaderThread is private inner class of NoVisibility class
        NoVisibility.main(new String[]{});

    }

}
