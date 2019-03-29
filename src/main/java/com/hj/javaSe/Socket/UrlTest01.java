package com.hj.javaSe.Socket;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Author: hj
 * Date: 2019-03-29 14:31
 * Description: <关于URL的常用方法>
 */
public class UrlTest01 {

    /*
    * 获取百度首页源码
    * */
    @Test
    void testUrl() throws MalformedURLException {
        //创建一个URL实例
        URL url=new URL("http://www.baidu.com");
        try {
            //通过URL的openStream方法获取URL对象所表示的资源的字节输入流
            InputStream is=url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            //字符输入流添加缓冲
            BufferedReader br=new BufferedReader(isr);
            //读取数据,按行读
            String data=br.readLine();
            while (data!=null){
                System.out.println(data);
                data=br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
