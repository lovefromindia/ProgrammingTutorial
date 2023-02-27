package com.learning.practicing;

import java.util.Arrays;

interface DeclareStuff{
    public static final int EASY = 3;

    void doStuff(int t);

}

//class TestDeclare implements DeclareStuff{
//
//    int i;
//
//    String str;
//
//    //Below this() causes recursive constructor calls and causes compilation error
//    TestDeclare(){
////        this();
//    }
//    public static void main(String[] args) {
//
//        TestDeclare t = new TestDeclare();
//
//        System.out.println(Arrays.toString(new int[5]));
//
//        System.out.println(t.i + " " + t.str);
//
//        int x = 5;
//
//        new TestDeclare().doStuff(++x);
//
//    }
//
//
//    //below will be error due visibility issues
//    @Override
//    void doStuff(int s) {
//
//        s += EASY + ++s;
//
//        System.out.println("s: " + s);
//
//    }
//
//}

public class LearningWeirdQuestion2 {

    public static int getMethod(){
        return 1;
    }
    public static void main(String[] args) {

        char c = 0x000A;

        float a = getMethod();

        StringBuilder sb1 = new StringBuilder("Mihir");
        StringBuilder sb2 = new StringBuilder("Mihir");

        System.out.println(sb1.compareTo(sb2));

        System.out.println(c);

    }

}
