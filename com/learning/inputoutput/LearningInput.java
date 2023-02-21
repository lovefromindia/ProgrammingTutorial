package com.learning.inputoutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Human{
    public String name;
    public int age;

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    Scanner sc = new Scanner(System.in);

    public Human(){

//        name = sc.nextLine();
//
//        age = sc.nextInt();


        try {

            name = in.readLine();

            age = Integer.valueOf(in.readLine());

//            age /= 0;

        }catch(Throwable e){

            System.out.println(e.getMessage());

        }

    }

    public Human(String name,int age){

        this.name = name;

        this.age = age;

    }

    @Override
    public String toString() {

        return "Name: " + name + "\nAge: " + age;

    }

}

public class LearningInput {

    private static String name;

    public static void main(String[] args) {

        double piValue = 3.141425343545;

        float piValueF = 3.14132433343433f;

        byte alphabet = 65;

        System.out.printf("This figure is rounded off %1.10f %f %c %d\n",piValue,piValueF,alphabet,alphabet);

        Human h = new Human();

        System.out.println(name);

        System.out.println(h);

        h = null;

        try {

            h.age = 30;

        }catch(Error e){

            System.out.println(e.getMessage());

        }

    }

}
