package me.yevgnenll.concurrent.task;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    public static void handleRequest(Socket connection) throws IOException {
        System.out.println(connection);
        connection.getOutputStream().write("hi there".getBytes());
        connection.getOutputStream().close();
        connection.close();

    }
}
