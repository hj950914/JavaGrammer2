package com.hj.javaSe.Socket.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: hj
 * Date: 2019-03-29 16:15
 * Description: <客户端端,基于TCP协议的Socket通信>
 */
public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        try {
            //1:创建客户端Socket,指定服务器地址和端口
            Socket socket = new Socket("127.0.0.1", 8888);
            //2:获得输出流,用来向服务器端发送信息
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            //将输出流包装为打印流
            PrintWriter pw = new PrintWriter(os);
            pw.write(s);
            pw.flush();
            //关闭输出流
            socket.shutdownOutput();
            //3:获取输入流,用来读取服务器端的响应
            InputStream is = socket.getInputStream();
            //字节流转字符流并且添加缓冲
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //服务端信息
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端,服务器端说:" + info);
            }
            //4:关闭资源
            br.close();
            is.close();
            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
