package com.hj.javaSe.Socket.TCP.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author: hj
 * Date: 2019-07-09 17:55
 * Description: <描述>
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",9999);
        OutputStream os=socket.getOutputStream();
        OutputStreamWriter osw=new OutputStreamWriter(os);
        BufferedWriter bw= new BufferedWriter(osw);
        Scanner scanner=new Scanner(System.in);
        String next = scanner.next();
        bw.write(next);
        bw.flush();
        socket.shutdownOutput();
        //接收服务器端的信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        System.out.println("服务器说:"+br.readLine());
    }
}
