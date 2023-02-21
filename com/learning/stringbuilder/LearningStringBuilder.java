package com.learning.stringbuilder;

import java.util.Arrays;

//class PrintingThread extends Thread{
//
//    char c = '?';
//
//    StringBuilder str = null;
//
//    int n = 10;
//
//    public PrintingThread(char c,StringBuilder str,int n){
//
//        this.c = c;
//
//        this.str = str;
//
//        this.n = n;
//
//        System.out.println(n);
//
//    }
//
//    public void run(){
//
//        for(int i = 0;i < n;i++) {
//
//            str.append(c);
//
////            System.out.println(str);
//
//        }
//
//    }
//
//}

public class LearningStringBuilder {

    static void appendString(StringBuilder str){

        for(int i = 0;i < 26;i++)
            str.append((char)(i+'a'));

    }

    public static void increaseCharacters(StringBuilder str){

        int previousCapacity = str.capacity();

        for(int i = 0;i < 26;i++){

            str.append((char)(i+'a'));

            System.out.println(str.capacity());

            if(previousCapacity < str.capacity()){

                System.out.println("Capacity changed at " + str);

                previousCapacity = str.capacity();

            }

        }

    }

    public static void decreaseCharacters(StringBuilder str){

        int previousCapacity = str.capacity();

        for(int i = 0;i < 26;i++){

            str.delete(str.length()-1,str.length());

//            System.out.println(str);

            if(previousCapacity < str.capacity()){

                System.out.println("Capacity changed at " + str);

                previousCapacity = str.capacity();

            }

        }

        System.out.println(str.capacity());

    }

    public static void main(String[] args) {


//        str.delete(0,100);//surprisingly it doesn't give any error like deleteCharAt()
//
//        increaseCharacters(str);
//
//        System.out.println("Decreasing Length");
//
//        decreaseCharacters(str);
//
//        System.out.println(str.length());

//        for(char c = 'a'; c <= 'z';c++){
//
//            PrintingThread p = new PrintingThread(c,str,(int)(1000000*Math.random()));
//
//            p.run();
//
//        }

//        char []word = str.toString().toCharArray();

//        Arrays.sort(word);

//        System.out.println(new String(word).equals(str.toString()));

//        System.out.println(new String(word));
//        System.out.println(str);

// Hence stringBuilder is fastest among StringBuffer and String
//        real    0m1.336s
//        user    0m1.854s
//        sys     0m0.260s

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < 10000000;i++){

            appendString(str);
//            System.out.println(str);
        }

    }

}
