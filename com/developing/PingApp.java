package com.developing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PingApp {

    private static final int DEFAULT_RETRY = 5;
    private static final int MIN_RETRY = 0;
    private static final int MAX_RETRY = 20;



    private static final int DEFAULT_RETRYINTERVAL = 25;
    private static final int MIN_RETRYINTERVAL = 15;
    private static final int MAX_RETRYINTERVAL = 1000;

    private static final int DEFAULT_RESPONSETIMEOUT = 500;
    private static final int MIN_RESPONSETIMEOUT = 10;
    private static final int MAX_RESPONSETIMEOUT = 1000;


    /**
     * Private Static Class which actually checks whether the host is up or down
     * contains checkIfUp() method which takes four values: ip, numberofretries, timeintervalbetweenretries
     */
    private static class PingExecutor {

        public static boolean checkIfUp(String targetIp,int numberOfRetry,int retryInterval,int responseTimeOut) {

            BufferedReader reader = null;

            ProcessBuilder processBuilder = null;

            ArrayList<String> commandList = null;

            String[] command = null;

            Process process = null;

            StringBuilder pingOutput = null;

            try{

                processBuilder = new ProcessBuilder();

                 commandList = new ArrayList<>();

                commandList.add("fping");

                commandList.add("-r" + numberOfRetry);

                commandList.add("-i" + retryInterval);

                commandList.add("-t" + responseTimeOut);

                commandList.add(targetIp);

                command = commandList.toArray(new String[commandList.size()]);

                //for logging
                System.out.println(Arrays.toString(command));

                processBuilder.command(command);

                processBuilder.redirectErrorStream(true);

                process = processBuilder.start();

                reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                int pingCommandExitCode = process.waitFor();

                if(pingCommandExitCode != 0 && pingCommandExitCode != 1){

                    throw new Exception("Ping Process has been exited with code " + pingCommandExitCode);

                }

                pingOutput = new StringBuilder();

                String line;

                while ((line = reader.readLine()) != null) {

                    pingOutput.append(line);

                }

                //for logging
                System.out.println("Ping: " + pingOutput.toString());

                return pingOutput.toString().contains("alive");

            }catch(Exception exception){

                System.out.println(exception.getMessage());

            }finally {

                try {

                    reader.close();

                } catch (IOException exception) {

                    System.out.println(exception.getMessage());

                }

            }

            System.out.println("Try again...");

            return false;

        }

    }

    public static void main(String[] args) {

        String targetIp;

        int retry=DEFAULT_RETRY,retryInterval=DEFAULT_RETRYINTERVAL,responseTimeOut=DEFAULT_RESPONSETIMEOUT;

        try {

            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter IP Address");

            targetIp = userInputReader.readLine();

            System.out.println(PingExecutor.checkIfUp(targetIp,retry,retryInterval,responseTimeOut));

        } catch (Exception exception) {

            System.out.println(exception.getMessage());

        }

    }

}
