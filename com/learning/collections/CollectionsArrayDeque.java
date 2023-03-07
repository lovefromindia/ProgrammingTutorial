package com.learning.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class CollectionsArrayDeque {

    public static void main(String[] args) {

        Deque<Character> dq =  new ArrayDeque<>();

        dq.offerFirst('b');

        dq.offerFirst('a');

        dq.offerLast('c');


        System.out.println(dq.peekFirst());

        System.out.println(dq.peek());

        System.out.println(dq.peekLast());

        System.out.println(dq.pollLast());

        System.out.println(dq);

    }

}
