package com.learning.collections;

import java.util.*;

public class CollectionsArrayList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        System.out.println(list.size());

        for(int i = 0;i < 16;i++){

            list.add(i);

            System.out.println(list.size());

        }

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));

        }

        System.out.println();

        for (Integer i :list) {

            System.out.print(i);

        }

        System.out.println();

        Iterator<Integer> it = list.iterator();

        Iterator<Integer> it2 = list.listIterator(1);

        while(it2.hasNext()){

            System.out.print(it2.next());

        }

        Queue<Integer> q = new PriorityQueue<>();

        Object[] strArr = new String[10];
        
    }

}
