package com.learning.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class StringComparator implements Comparator<String>{

    @Override
    public int compare(String s, String t) {
        return -1 * s.compareTo(t);
    }
}

public class CollectionsPriorityQueue {

    public static void main(String[] args) {

        Queue<String> stringPriorityQueue = new PriorityQueue<>(new StringComparator());

        stringPriorityQueue.offer("z");

        stringPriorityQueue.offer("y");

        stringPriorityQueue.offer("x");

        stringPriorityQueue.offer("a");

        stringPriorityQueue.offer("g");

        System.out.println(stringPriorityQueue.peek());

        System.out.println(stringPriorityQueue);

        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        integerPriorityQueue.offer(020);

        integerPriorityQueue.offer(110);

        integerPriorityQueue.offer(-1);

        integerPriorityQueue.offer(102);

        System.out.println(integerPriorityQueue.peek());

        System.out.println(integerPriorityQueue.poll());

        System.out.println(integerPriorityQueue.poll());

    }

}
