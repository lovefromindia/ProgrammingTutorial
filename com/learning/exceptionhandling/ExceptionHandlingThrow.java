package com.learning.exceptionhandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ExceptionHandlingThrow {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException,ArithmeticException {

//      ****Scenerio 1:
        takeInput(br);

//        ****Scenerio 2:
//        try {
//            takeInput(br);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }

    }

    public static Integer takeInput(BufferedReader br) throws IOException {

        Integer age = Integer.valueOf(br.readLine());

        //****Below snippet will give compilation error
//        try {
//
//        } catch (Exception e) {
//
//        } catch (ArithmeticException a) {
//
//        }

        try {

            age = age / 0;

        }finally{

            System.out.println("runned");

            String str = br.readLine();//can be called without try...catch because i have used 'throws'

        }

        return age;

    }

//    public static void tereLiyeAisa() throws IOException{
//        br.readLine();
//    }

}