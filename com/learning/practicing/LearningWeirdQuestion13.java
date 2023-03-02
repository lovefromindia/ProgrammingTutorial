package com.learning.practicing;

class Vehicle{
//    private final int vari;//**If we don't initialize it will give
//    error as we are not initializing it anywhere
    Vehicle(){
    }
}
public class LearningWeirdQuestion13 {

    public static void main(String[] args) {

        final String ss1 = "asdf";
        final String ss2 = "asdf";
        System.out.println(ss1+ss2 == "asdfasdf");//true as compiler replaces final values with the literal values given in code (if present) hence the '+' will not be used

        String s1 = "asdf";
        String s2 = "asdf" + "" + "";
        System.out.println(s1 == s2);//true as compiler at compile time removes "" and makes the string s2 = asdf

        final String s3 = "asdf";
        String s4 = "asdf";
        String s5 = s3+s4;
        System.out.println(s5==(s3+s4));//false as one of the string is not final
    }

}
