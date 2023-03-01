package com.learning.practicing;

class SuperClass{

    public int doIt(String str, Integer... data)throws Exception{

        String signature = "(String, Integer[])";

        System.out.println(str + " " + signature);

        return 1;

    }

}

class Test extends SuperClass{

    public int doIt(String str, Integer... data){

        String signature = "(String, Integer[])";

        System.out.println("Overridden: " + str + " " +signature);

        return 0;

    }

}


public class LearningWeirdQuestion6 {

    public static void main(String... args){

        SuperClass sb = new Test();

//        sb.doIt("hello", 3);

    }

}
