package com.learning.collections;

import java.util.*;

class A{
    public void m1(){}
}

class B extends A{
    public synchronized void m1(){}
}


public class CollectionsLinkedList {

    public static void main(String[] args) {

        Queue<String> linkedList = new LinkedList<>();

        linkedList.offer(null);

        linkedList.offer("Mihir");

        linkedList.offer("SOS");

        linkedList.offer("OMG");

        System.out.println(linkedList.peek());

        System.out.println(linkedList.poll());

        System.out.println(linkedList);

        List<String> list = new LinkedList<>();
        list.add("Mihir");
        list.add("Mahir");
        list.add("Mhir");
        ListIterator<String> it = list.listIterator();


    }

}
