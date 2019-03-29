package com.hj.javaSe.Socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Author: hj
 * Date: 2019-03-29 18:04
 * Description: <服务器端,基于UDP的Socket>
 */
public class Server {

    public static void main(String[] args) {
        //1;创建服务器端DatagramSocket,指定端口
        DatagramSocket socket = null;
        //2:创建数据报,用于接收客户端发送的数据或者响应客户端
        DatagramPacket packet = null;
        byte[] data = null;

        try {
            socket = new DatagramSocket(8800);
            data = new byte[1024];
            //指定接收的数据存入data字节数组
            packet = new DatagramPacket(data, data.length);
            //3:接收客户端发送的数据,此方法在接收到数据之前会一直阻塞
            System.out.println("***服务器即将启动,等待客户端的连接***");
            socket.receive(packet);
            //4:读取数据
            String info = new String(data, 0, packet.getLength());
            System.out.println("我是服务器,客户端说:" + info);

            /*
             * 向客户端响应数据
             * */
            //1.定义客户端的地址,端口号,数据
            InetAddress address=packet.getAddress();
            int port=packet.getPort();
            byte[] data2="欢迎你,new".getBytes();
            //2.创建数据包,包含响应的数据
            packet=new DatagramPacket(data2,data2.length,address,port);
            //3.响应客户端
            socket.send(packet);
            //4.关闭资源
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
