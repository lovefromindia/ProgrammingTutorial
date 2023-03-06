package com.learning.datastructures;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class UMaxHeap<T extends Comparable>{

    private ArrayList<T> array;

    UMaxHeap(){

        array = new ArrayList<T>();

    }

    UMaxHeap(ArrayList<T> arr){
        array = arr;
        for(int i = arr.size()/2;i >= 0;i--){
            rearrangeHeap(i);
        }
    }

    private void swap(int i1,int i2){

        T temp = array.get(i1);

        array.set(i1, array.get(i2));

        array.set(i2,temp);

    }

    void insert(T data){

        array.add(data);

        int index = array.size()-1;

        while((index-1)/2>=0 && data.compareTo(array.get((index-1)/2)) > 0){

            swap(index, (index - 1) / 2);

            index = (index-1)/2;

        }

    }

    T pop() throws IllegalAccessException{

        if(array.size()==0)
            throw new IllegalAccessException();

        T temp = array.get(0);

        array.set(0,array.get(array.size()-1));

        array.remove(array.size()-1);//removes the last element which contains top element reference

        if(array.size()>0)
            rearrangeHeap(0);

        return temp;

    }

    private void rearrangeHeap(int in) {

        int index = in,largestIndex = in;

        while(true){

            largestIndex = index;

            if(((index<<1)+1 < array.size()) && array.get(largestIndex).compareTo(array.get((index<<1)+1)) < 0){

                largestIndex = (index<<1)+1;

            }

            if(((index<<1)+2 < array.size()) && array.get(largestIndex).compareTo(array.get((index<<1)+2)) < 0){

                largestIndex = (index<<1)+2;

            }

            if(largestIndex==index)
                break;

            swap(largestIndex,index);

            index = largestIndex;

        }

    }

    public T peek() throws IllegalAccessException{

        if(array.size()==0)

            throw new IllegalAccessException();

        return array.get(0);

    }

    public boolean isEmpty(){

        return (array.size()==0);

    }

    @Override
    public String toString() {

        return array.toString();

    }

    public static void main(String[] args) {

        UMaxHeap<Integer> uMaxHeap = new UMaxHeap<>();
        uMaxHeap.insert(11);
        System.out.println(uMaxHeap);
        uMaxHeap.insert(10);
        System.out.println(uMaxHeap);
        uMaxHeap.insert(8);
        System.out.println(uMaxHeap);
        uMaxHeap.insert(9);
        System.out.println(uMaxHeap);
        try {
            System.out.println(uMaxHeap.peek());
        }catch(Exception e){
        }
        uMaxHeap.insert(1);
        System.out.println(uMaxHeap);
        uMaxHeap.insert(-1);
        System.out.println(uMaxHeap);
        uMaxHeap.insert(24);
        System.out.println(uMaxHeap);
        uMaxHeap.insert(-200);
        System.out.println(uMaxHeap);

        try {
            System.out.println(uMaxHeap.pop());
            System.out.println(uMaxHeap);
            System.out.println(uMaxHeap.pop());
            System.out.println(uMaxHeap);
            System.out.println(uMaxHeap.pop());
            System.out.println(uMaxHeap);
            System.out.println(uMaxHeap.pop());
        }catch (Exception e){}

        UMaxHeap<Human> uMaxHeap1 = new UMaxHeap<Human>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(1);
        arr.add(3);
        arr.add(9);
        arr.add(0);
        arr.add(7);
        UMaxHeap<Integer> uMaxHeap2 = new UMaxHeap<>(arr);
        try {
            while(!uMaxHeap2.isEmpty()) {
                System.out.println(uMaxHeap2.pop());
            }
        }catch (Exception e){}

//        String sarr[] = {"loki"};
//        System.out.println(sarr.length);
    }
}

class Human implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }

}
