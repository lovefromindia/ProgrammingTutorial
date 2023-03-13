package com.developing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PingApp {

    private static final int DEFAULT_RETRY = 3;
    private static final int DEFAULT_RETRYINTERVAL = 100;

    /**
     * Private Static Class which actually checks whether the host is up or down
     * contains checkIfUp() method which takes three values: ip, numberofretries, timeintervalbetweenretries
     */
    private static class PingExecutor {

        private static String[] getCommand(String targetIp, int numberOfRetry,int retryInterval){

            ArrayList<String> command = new ArrayList<>();

            command.add("fping");

            command.add("-r"+numberOfRetry);

            command.add("-i"+retryInterval);

            command.add(targetIp);

            return command.toArray(new String[command.size()]);

        }

        private static boolean checkIfAlive(String pingOuput){

            System.out.println(pingOuput);

            return pingOuput.contains("alive");

        }

        public static boolean checkIfUp(String targetIp,int numberOfRetry,int retryInterval) throws IOException {

            ProcessBuilder processBuilder = new ProcessBuilder();

            System.out.println(Arrays.toString(getCommand(targetIp,numberOfRetry,retryInterval)));
            processBuilder.command(getCommand(targetIp,numberOfRetry,retryInterval));

            Process process = processBuilder.start();

            StringBuilder pingOutput = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while (process.isAlive()) {

                line = reader.readLine();

                if(line != null)

                    pingOutput.append(line);

            }

            return checkIfAlive(pingOutput.toString());

        }

        public static boolean checkIfUp(String targetIp) throws IOException{

            return checkIfUp(targetIp,DEFAULT_RETRY,DEFAULT_RETRYINTERVAL);

        }

    }

    public static void main(String[] args) {

        try {

            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter IP Address");

            String targetIp = userInputReader.readLine();

            System.out.println("Number of Retries?[Max 5]");

            int retry = Math.min(Math.max(Integer.valueOf(userInputReader.readLine()),1),5);

            System.out.println("Time Interval between each Retry?");

            int retryInterval = Math.min(Math.max(Integer.valueOf(userInputReader.readLine()),1),10);

            System.out.println(PingExecutor.checkIfUp(targetIp,retry,retryInterval));


        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
