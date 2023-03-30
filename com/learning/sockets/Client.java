package com.learning.sockets;
import java.io.*;
import java.net.Socket;

public class Client{

    public static void request(){
        try{

            Socket connection = new Socket("localhost",9999);
            DataOutputStream writer = new DataOutputStream(connection.getOutputStream());

            BufferedReader messenger = new BufferedReader(new InputStreamReader(System.in));
            String line;

            new Thread(()->{
                try {
                    DataInputStream reader = new DataInputStream(connection.getInputStream());
                    String lin = null;
                    while((lin = reader.readUTF()) != null){
                        System.out.println(lin);
                    }
                } catch (Exception exception) {
//                System.out.println(exception.getMessage());
                }
            }).start();
            while((line = messenger.readLine()) != "exit"){
                writer.writeUTF(line);

            }
//            writer.flush();
//            String line;
//            while((line = reader.readLine()) != null){
//                System.out.println(line);
//            }

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static void main(String[] args) {
        Client.request();
    }
}