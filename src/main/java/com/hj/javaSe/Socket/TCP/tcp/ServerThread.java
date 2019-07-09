package com.hj.javaSe.Socket.TCP.tcp;

import java.io.*;
import java.net.Socket;

/**
 * Author: hj
 * Date: 2019-07-09 17:12
 * Description: <描述>
 */
public class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread() {
    }

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //读
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        //写
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            //接收客户端发送的信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("客户端说:" + info);
            }
            socket.shutdownInput();
            //向客户端发送信息
            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.write("欢迎您,客户端");
            pw.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (isr != null)
                    isr.close();
                if (br != null)
                    br.close();
                if (os != null)
                    os.close();
                if (pw != null)
                    pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
