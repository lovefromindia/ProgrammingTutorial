package com.learning.plusoperator;

import java.util.ArrayList;
import java.util.Arrays;

public class LearningsOperator {

    public static void main(String[] args) {

        //the evaluation happens from left to right for the print expression
        //if any of the one operand is of type string then automatically
        //java will call toString() method for the other operand
        //and the result will be String only
        //But if two operands are char and we do '+' then both ascii values' are added

        System.out.println((char)('a'+'b') + " ");

        System.out.println('a'+ 1 + " ");

        System.out.println(" " + 'a'+ 3);

        System.out.println("Mihir " + new Integer[]{1,23});
        System.out.println("Mihir " + (new Integer[]{1,23}).getClass());

        System.out.println("Mihir " + Arrays.toString(new Integer[]{1,23}));

        Integer[] arr = {1,23};

        System.out.println(arr);

        Integer[][] arr2 = new Integer[][]{{1,2},{3,4}};

        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.deepToString(arr2));

//        System.out.println(new ArrayList<>() + new Integer(2));
//
//        System.out.println(new ArrayList<>() + new Integer(2) + " ");

        System.out.println(" " + new ArrayList<>() + new Integer(2));

    }

}
