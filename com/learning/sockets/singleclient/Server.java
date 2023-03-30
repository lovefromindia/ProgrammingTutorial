package com.learning.sockets.singleclient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void start(){
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);

            while(true){
                System.out.println(server);
                handle(server.accept());
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }finally {
            try {
                server.close();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static void handle(Socket connection){

        new Thread(()->{

            try {
                DataOutputStream dout = new DataOutputStream(connection.getOutputStream());
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

                String data = "";
                while((data = bf.readLine()) != "exit")
                {
                    dout.writeUTF(data);

                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }).start();

        if(connection != null){
            try {
                DataInputStream reader = new DataInputStream(connection.getInputStream());
                String line = null;
                while((line = reader.readUTF()) != null){
                    System.out.println(line);
                }
            } catch (Exception exception) {
//                System.out.println(exception.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Server.start();
    }

}
