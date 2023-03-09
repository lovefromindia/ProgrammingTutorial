package com.learning.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class ArrayIterator {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>( Arrays.asList(1,2,3,4,5));

        Iterator<Integer> itr = arr.iterator();

//        System.out.println("list: "+arr);
        System.out.println(arr.size());

            while (itr.hasNext()) {

                if (itr.next().equals(3)) {

                    Integer val = itr.next();

//                    System.out.println(itr.next());

                    arr.remove(0);

                    itr.remove();
//                    System.out.println(itr.hasNext());
                }

            }

        int age = 0;

        System.out.println(age = 30);
//            System.out.println(arr);
        }
//        System.out.println("List "  + arr);
    }
