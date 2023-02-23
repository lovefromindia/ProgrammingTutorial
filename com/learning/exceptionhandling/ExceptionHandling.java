package com.learning.exceptionhandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionHandling {
    static {
        System.out.println("static");
    }

    public static void randomMethod(){
        int i  = 1/0;
    }
    public static void main(String[] args) throws IOException{

        try{

            randomMethod();

        }catch (Exception e){

            System.out.println("Here " + e.getMessage());

        }

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        f.read();

        Integer age = null;

        try{

            age = Integer.valueOf(f.readLine());

            System.out.println(age);

        }catch(NullPointerException e){

            System.out.println(e.getMessage());

        }catch(Exception e) {
//
//            e = null; // valid

            System.out.println("In here" + e.getMessage());
//        catch(Exception e){
//
//        }
        }finally{

            System.out.println(age);

        }

        try{

            age = Integer.valueOf(f.readLine());

            System.out.println(age);

        }catch(IOException | NullPointerException e){
//            e = null; gives error as e is final variable
            System.out.println(e.getMessage());

        }finally{

            System.out.println(age);

        }

        try{

        }finally{

            System.out.println("king");

        }

    }

}
