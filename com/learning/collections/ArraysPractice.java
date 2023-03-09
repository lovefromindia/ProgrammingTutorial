package com.learning.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysPractice {

    public static void main(String[] args) {

        Integer[] arr = {45,4,21,2,3,4,4,5,6};

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr,4));

    }

}
