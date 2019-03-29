package com.hj.javaSe.Socket.TCP;

import java.io.*;
import java.net.Socket;

/**
 * Author: hj
 * Date: 2019-03-29 17:17
 * Description: <服务器端线程处理类>
 */
public class ServerThread extends Thread {

    //和本线程相关的Socket
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    //线程执行的操作,响应客户端的请求
    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;
        try {
            //获取字节输入流,用来读取客户端信息
            is = socket.getInputStream();
            isr = new InputStreamReader(is, "utf-8");
            //添加缓冲
            br = new BufferedReader(isr);
            //客户端信息
            String info;
            while ((info = br.readLine()) != null) {
                System.out.println("我是服务器,客户端说:" + info);
            }
            //关闭输入流
            socket.shutdownInput();
            //获取输出流,响应客户端的请求
            os = socket.getOutputStream();
            //包装为打印流
            pw = new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                if (pw != null)
                    pw.close();
                if (os != null)
                    os.close();
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
