package com.learning.concurrencyisweird;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadServer {
    public static void main(String[] args) {
        ServerSocket socket = null;
        Socket connection;
        try {
            socket = new ServerSocket(5555);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        while(true){
            try {
                connection = socket.accept();
                handleRequest(connection);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }finally {
//                try {
//                } catch (Exception exception) {
//                    System.out.println(exception.getMessage());
//                }
            }
        }
    }

    private static void handleRequest(Socket connection) {
        //some long blocking computation
        try {
            Thread.sleep(10000);
        } catch ( e) {
            throw new RuntimeException(e);
        }
        System.out.println(connection.toString());
    }
}
