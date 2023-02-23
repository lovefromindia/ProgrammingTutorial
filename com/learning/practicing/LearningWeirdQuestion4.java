package com.learning.practicing;

public class LearningWeirdQuestion4 {

    public static void main(String[] args) {

        try {

            getException();

            badMethod();

            System.out.println("A");

        }catch (Exception e){//*** doesn't catch the error because Error is the sibling class of Exception and not child

            System.out.println("B");

        }finally {//*** so finally will be called and after that the exception/error is propogated upwards

            System.out.println("C");
        }

    }

    static void badMethod(){

        throw new Error();

    }

    static Exception getException(){

        return new Exception();//Below code is working like it's returning normal objects in java

    }

}
