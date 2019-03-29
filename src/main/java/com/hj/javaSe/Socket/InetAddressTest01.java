package com.hj.javaSe.Socket;

import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Author: hj
 * Date: 2019-03-29 14:04
 * Description: <InetAddress类测试>
 */
public class InetAddressTest01 {

    /*
    * 通过InetAddress类获取本机信息
    * */
    @Test
    void testOne() throws UnknownHostException {
        //获取本机的InetAddress实例
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("计算机名:" + inetAddress.getHostName());
        System.out.println("主机IP地址:" + inetAddress.getHostAddress());
        //获取字节数组形式的IP
        byte[] b = inetAddress.getAddress();
        System.out.println("字节数组中IP的内容:" + Arrays.toString(b));

    }
}
