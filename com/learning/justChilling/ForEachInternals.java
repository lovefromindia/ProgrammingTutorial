package com.learning.justChilling;

import java.util.ArrayList;
import java.util.List;

//Let's see how byte code for forEach loop looks like
public class ForEachInternals {
    public static void main(String[] args) {
        Integer l[] = {10,20,30,40} ;

        for (Integer i:
             l) {
            System.out.println(i);
        }
    }
}
