package com.learning.stringperformance;

public class LearningStringPerformance {

    static String appendString(String str){

        for(int i = 0;i < 26;i++)
            str += (char)(i+'a');

        return str;

    }

    //below time just for 10% of program because i had ctrl^c the program
//    real    3m33.386s
//    user    3m42.226s
//    sys     0m2.298s

    public static void main(String[] args) {

        String str = new String();

        for(int i = 0; i < 1000;i++){

            str = appendString(str);
//            System.out.println(str);
        }

    }

}
