package com.learning.practicing;

// ***Below 9 out of 10 times the order of statements are:
// 1) Finally block and 2) Arithmetic Exception Message
class ExceptionThrower{
    public static void method() {

        try{

            throw new ArithmeticException();

        }finally {

            System.out.println("This is shit!!!");

        }

    }
}

public class LearningWeirdQuestion12 {

    public static void main(String[] args) {

        for(int i = 0;i < 10;i++)

            ExceptionThrower.method();

    }

}

interface Building{
    private void method() {

    }

}
