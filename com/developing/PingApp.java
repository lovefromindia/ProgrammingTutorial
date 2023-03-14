package com.developing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PingApp {

    private static final int DEFAULT_RETRY = 3;
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
     * contains checkIfUp() method which takes three values: ip, numberofretries, timeintervalbetweenretries
     */
    private static class PingExecutor {

        private static String[] getCommand(String targetIp, int numberOfRetry,int retryInterval,int responseTimeOut){

            ArrayList<String> command = new ArrayList<>();

            command.add("fping");

            command.add("-r"+numberOfRetry);

            command.add("-i"+retryInterval);

            command.add("-t"+responseTimeOut);

            command.add(targetIp);

            return command.toArray(new String[command.size()]);

        }

        private static boolean checkIfAlive(String pingOuput){

            System.out.println(pingOuput);

            return pingOuput.contains("alive");

        }

        public static boolean checkIfUp(String targetIp,int numberOfRetry,int retryInterval,int responseTimeOut) throws IOException, InterruptedException {

            ProcessBuilder processBuilder = new ProcessBuilder();

            System.out.println(Arrays.toString(getCommand(targetIp,numberOfRetry,retryInterval,responseTimeOut)));
            processBuilder.command(getCommand(targetIp,numberOfRetry,retryInterval,responseTimeOut));

            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            process.waitFor();

            StringBuilder pingOutput = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                pingOutput.append(line);

            }

            return checkIfAlive(pingOutput.toString());

        }

        public static boolean checkIfUp(String targetIp) throws IOException, InterruptedException {

            return checkIfUp(targetIp,DEFAULT_RETRY,DEFAULT_RETRYINTERVAL,DEFAULT_RESPONSETIMEOUT);

        }

    }

    public static void main(String[] args) {

        String targetIp;
        int retry=DEFAULT_RETRY,retryInterval=DEFAULT_RETRYINTERVAL,responseTimeOut=DEFAULT_RESPONSETIMEOUT;

        try {

            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter IP Address");

            targetIp = userInputReader.readLine();

            System.out.println("Use Default Values?[Y/N]");

            String useDefaultValues = userInputReader.readLine();

            if(useDefaultValues.toLowerCase().equals("n")) {

                System.out.println("Number of Retries?[Min:" + MIN_RETRY + ",Max:" + MAX_RETRY + "]");

                retry = Math.min(Math.max(Integer.valueOf(userInputReader.readLine()), MIN_RETRY), MAX_RETRY);

                System.out.println("Time Interval between each Retry?[Min:" + MIN_RETRYINTERVAL + ",Max:" + MAX_RETRYINTERVAL + "]");

                retryInterval = Math.min(Math.max(Integer.valueOf(userInputReader.readLine()), MIN_RETRYINTERVAL), MAX_RETRYINTERVAL);

                System.out.println("Timeout For Each Response?[Min:" + MIN_RESPONSETIMEOUT + ",Max:" + MAX_RESPONSETIMEOUT + "]");

                responseTimeOut = Math.min(Math.max(Integer.valueOf(userInputReader.readLine()), MIN_RESPONSETIMEOUT), MAX_RESPONSETIMEOUT);

            }

            System.out.println(PingExecutor.checkIfUp(targetIp,retry,retryInterval,responseTimeOut));

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

}
