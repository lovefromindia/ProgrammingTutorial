package com.learning.collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CollectionsLinkedList {

    public static void main(String[] args) {

        Queue<String> linkedList = new LinkedList<>();

        linkedList.offer("Mihir");

        linkedList.offer("SOS");

        linkedList.offer("OMG");

        System.out.println(linkedList.peek());

        System.out.println(linkedList.poll());

        System.out.println(linkedList);

    }

}
