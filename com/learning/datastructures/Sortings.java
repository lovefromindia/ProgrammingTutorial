package com.learning.datastructures;

import java.util.ArrayList;

class QuickSort{

    public static<T extends Comparable<T>> void sort(ArrayList<T> arr){
        sort(0,arr.size()-1,arr);
    }
    private static<T extends Comparable<T>> void sort(int start, int end, ArrayList<T> arr){
        if(start >= end)
            return;
        int p = start,q = start;
        while(q < end){
            if(arr.get(q).compareTo(arr.get(end)) < 0){
                swap(p,q,arr);
                p++;
            }
            q++;
        }
        swap(p, end,arr);
//        System.out.println(arr);
        sort(start,p-1, arr);
        sort(p+1, end, arr);
    }

    private static<T extends Comparable<T>> void swap(int p, int q, ArrayList<T> arr) {
        T temp = arr.get(p);
        arr.set(p,arr.get(q));
        arr.set(q,temp);
    }
}

class MergeSort{
    public static<T extends Comparable<T>> void sort(ArrayList<T> arr){
        sort(0,arr.size()-1,arr);
    }
    private static<T extends Comparable<T>> void sort(int startIndex, int endIndex, ArrayList<T> arr){
        if(startIndex >= endIndex)
            return;

        int mid = (startIndex+endIndex)/2;

        //divide and recursive calls to sort
        sort(startIndex, mid, arr);
        sort(mid+1, endIndex, arr);

        //merge the two sorted arrays
        ArrayList<T> mergedArray = new ArrayList<>();
        int i = startIndex,j = mid+1;
        while(i <= mid && j <= endIndex){
            if(arr.get(i).compareTo(arr.get(j)) < 0){
                mergedArray.add(arr.get(i));
                i++;
            }
            else{
                mergedArray.add(arr.get(j));
                j++;
            }
        }

        //remaining elements
        while(i <= mid){
            mergedArray.add(arr.get(i));
            i++;
        }

        //remaining elements
        while(j <= endIndex){
            mergedArray.add(arr.get(j));
            j++;
        }

        for(int k = 0;k < mergedArray.size();k++){
            arr.set(k+startIndex,mergedArray.get(k));
        }

    }

    private static<T extends Comparable<T>> void swap(int p, int q, ArrayList<T> arr) {
        T temp = arr.get(p);
        arr.set(p,arr.get(q));
        arr.set(q,temp);
    }
}

class Coordinate implements Comparable<Coordinate>{
    int x,y;
    Coordinate(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Coordinate o) {
        return this.x==o.x?this.y-o.y:this.x-o.x;
    }
}

public class Sortings {

    public static void main(String[] args) {
        ArrayList<Coordinate> arr = new ArrayList<>();
        arr.add(new Coordinate(3,4));
        arr.add(new Coordinate(3,3));
        arr.add(new Coordinate(4,0));
        arr.add(new Coordinate(1,-1));
        arr.add(new Coordinate(9,-1));
        arr.add(new Coordinate(3,0));
        QuickSort.sort(arr);
        System.out.println(arr);

        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(4);
        arr1.add(3);
        arr1.add(4);
        arr1.add(-1);
//        QuickSort.sort(arr1);
        MergeSort.sort(arr1);
        System.out.println(arr1);
    }

}
