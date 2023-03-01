package com.learning.practicing;

class Vehicle{
//    private final int vari;//**If we don't initialize it will give
//    error as we are not initializing it anywhere
    Vehicle(){
    }
}
public class LearningWeirdQuestion13 {

    public static void main(String[] args) {
        String s1 = "asdf";
        String s2 = "asdf" + "" + "";
//        System.out.println(s1 == s2);
        final String s3 = "asdf";
        String s4 = "asdf";

        String s5 = s3+s4;
        System.out.println(s5==(s3+s4));
    }

}
