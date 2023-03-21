package com.learning.lambda;

import java.text.Annotation;
import java.util.ArrayList;
import java.util.Arrays;

interface Greeting{
    void perform(int p);
}

//example of markup interface
@FunctionalInterface
interface Message{
    default int printYo(){
        System.out.println("yo");
        return 0;
    }

    static int myStaticMethod(){
        System.out.println("my static method");
        return 0;
    }

    int printMessage();
}

class Printer{
    Message m = null;

    Printer(Message m){
        this.m = m;
    }

    void print(){
        m.printMessage();
    }
}

public class LearningLambda {
    public static void main(String[] args) {

        Greeting g = new Greeting() {
            @Override
            public void perform(int p) {

            }
        };


        ArrayList list = new ArrayList();
        list.sort((o, t1) -> 0);

        new Printer(()->{
            System.out.println("Printing File");
            return 0;
        }).print();
        new Printer(()->{
            System.out.println("Printing Photo");
            return 0;
        }).print();

        Message m = new Message() {
            @Override
            public int printMessage() {
                System.out.println("In a anonymous object");
                return 0;
            }
        };
        new Printer(m).print();
        m = ()->{
            System.out.println("I am a lambda expression acting as if i am method assigned to m");
            return 9;
        };
        new Printer(m).print();

        new Greeting(){
            @Override
            public void perform(int i){
                System.out.println(i);
            }
        }.perform(10);
    }
}
