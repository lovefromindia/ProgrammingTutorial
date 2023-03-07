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

        list.add(Integer.valueOf(3),9);

        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i));

        }

    }

}
