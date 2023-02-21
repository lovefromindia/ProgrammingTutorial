package com.learning.exceptions;

public class LearningExceptions {

    public String getName() throws NullPointerException{

        System.out.println(this);

        return "Mihir";

    }
    public static void main(String args[]){

        LearningExceptions l = new LearningExceptions();

        try {

            System.out.println(l.getName());

        }catch(Exception e){

            System.out.println(e.getMessage());

        }

        l = null;

        System.out.println(l.getName());

    }

}
