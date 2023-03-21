package com.learning.processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderExample {

    public static void main(String[] args) {

        ProcessBuilder p = new ProcessBuilder("pidstat");
        p.redirectErrorStream(true);
        Process pr = null;
        try {
            pr = p.start();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String line = null;
            try {
                while((line = r.readLine()) != null){
                    System.out.println(line);
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
    }

}
