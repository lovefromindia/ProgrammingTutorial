package com.developing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public final class PingApp {
    public static final int checkStatus(String ip){

        try {
            if (!validateIP(ip)) {
                return -1;
            }

            ProcessBuilder builder = new ProcessBuilder();
            builder.command(getCommand(ip));
            builder.redirectErrorStream(true);

            Process process = builder.start();
            int exitCode = process.waitFor();
            if(exitCode != 0 && exitCode != 1){
                return -1;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while((line=reader.readLine()) != null){
                result.append(line);
            }

            return parseResult(result).get("%loss").equals("0%")?1:0;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return -1;
        }
    }

    private static Map<String,String> parseResult(StringBuilder result) {
        Map<String,String> results = new HashMap<>();
        Arrays.stream(result.toString()
                        .split(":")[1]
                        .split(","))
                .forEach(s -> {
            String[] keyValues = s.split("=");
            if(keyValues.length==2){
                String[] keys = keyValues[0].split("/");
                String[] values = keyValues[1].split("/");
                for (int i = 0; i < keys.length; i++) {
                    results.put(keys[i].strip(),values[i].strip());
                }
            }
        });
        return results;
    }

    private static List<String> getCommand(String ip) {
        List<String> command = new ArrayList<>();
        command.add("fping");
        command.add("-c3");
        command.add("-q");
        command.add(ip);
        return command;
    }

    private static final boolean validateIP(String ip){
        return true;
    }

}
