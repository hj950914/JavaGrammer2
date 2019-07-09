package com.hj.javaSe.Socket.TCP.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Author: hj
 * Date: 2019-07-09 17:09
 * Description: 服务端
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket;
        //记录客户端数量
        int count = 0;
        //循环监听
        while (true) {
            socket = serverSocket.accept();
            //创建新的线程
            ServerThread serverThread = new ServerThread(socket);
            Thread thread = new Thread(serverThread);
            thread.start();
            count++;
            System.out.println("客户端连接数:" + count);
            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("当前客户端IP地址为:" + inetAddress.getHostAddress());
        }
    }
}
