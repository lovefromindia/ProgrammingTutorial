package com.learning.stringbuffer;

public class LearningStringBuffer {

    static void appendString(StringBuffer str){

        for(int i = 0;i < 26;i++)
            str.append((char)(i+'a'));

    }

//    real    0m5.309s
//    user    0m5.540s
//    sys     0m0.237s

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer();

        for(int i = 0; i < 10000000;i++){

            appendString(str);
//            System.out.println(str);
        }

    }

}
