package com.learning.plusoperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class LearningsOperator {

    public static void main(String[] args) {

        //the evaluation happens from left to right for the print expression
        //if any of the one operand is of type string then automatically
        //java will call toString() method for the other operand
        //and the result will be String only
        //But if two operands are char and we do '+' then both ascii values' are added

        System.out.println((char)('a'+1) + " ");

        System.out.println('a'+ 1 + " ");

        System.out.println(" " + 'a'+ 3);

        //implicit call to Arrays will be made which will be just cryptic value containing className@HashValue
        System.out.println("Mihir " + new Integer[]{1,23});
        System.out.println("Mihir " + (new Integer[]{1,23}).getClass());

        System.out.println("Mihir " + Arrays.toString(new Integer[]{1,23}));

        Integer[] arr = {1,23};

        System.out.println(arr);

        Integer[][] arr2 = new Integer[][]{{1,2},{3,4}};

        System.out.println(Arrays.toString(arr2));

        //deepToStrig for printing arrays having more than one dimension
        System.out.println(Arrays.deepToString(arr2));


        //****Below two statements will give error as there is no '+' overloaded by java for
        //Array and Integer
        //However third statement below will be normal as evaluation happens from left to right so,
        // String + ArrayList = String
        //String + Integer = String
//        System.out.println(new ArrayList<>() + new Integer(2));
//
//        System.out.println(new ArrayList<>() + new Integer(2) + " ");

        System.out.println(" " + new ArrayList<>() + new Integer(2));

    }

}
