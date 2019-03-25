package com.hj.javaSe.JDK;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Author: hj
 * Date: 2019-03-25 14:57
 * Description: <文件IO,文件输入-读，文件输出-写>
 *              <字节流,字节缓冲流,字符流>
 */
public class IoDemo {

    /*
     * File类:读文件,创建文件
     * /Users/huangjie/Desktop/IO/
     * */
    @Test
    void testOne() {
        //创建File对象
        File file1 = new File("/Users/huangjie/Desktop/IO/score.txt");
        //判断是文件还是目录
        System.out.println("是否是目录:" + file1.isDirectory());
        System.out.println("是否是文件:" + file1.isFile());
        //创建新文件
        File file2 = new File("/Users/huangjie/Desktop/IO/HashSet");
        //判断文件是否存在
        if (!file2.exists()) {
            //创建多重目录使用mkdirs()
            file2.mkdir();
        }
        //创建文件
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * InputStream和OutPutStream,输入输出流
     * FileInputStream（读文件）
     * FileOutPutStream(写文件)
     * */
    @Test
    void testTwo() {

        //创建一个FileInputStream（读文件）
        {
            try {
                FileInputStream fis = new FileInputStream("/Users/huangjie/Desktop/IO/score.txt");
                int n = 0;
                //判断是否读完
                while ((n = fis.read()) != -1) {
                    System.out.print((char) n);
                }
                System.out.println();
                //关闭输入流
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //创建一个FileInputStream（读文件）
        {
            try {
                FileInputStream fis = new FileInputStream("/Users/huangjie/Desktop/IO/score.txt");
                byte[] b = new byte[10];
                //将读取的内容存入字节数组
                fis.read(b, 0, 5);
                System.out.println(new String(b));
                System.out.println();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //创建一个FileOutPutStream（写文件）
        {
            FileOutputStream fos = null;
            FileInputStream fis = null;
            try {
                fos = new FileOutputStream("/Users/huangjie/Desktop/IO/score.txt");
                fis = new FileInputStream("/Users/huangjie/Desktop/IO/score.txt");
                fos.write(50);
                fos.write('a');
                System.out.println(fis.read());
                System.out.println((char) fis.read());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null) {
                        fos.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /*
     * 文件拷贝
     * */
    @Test
    void testThree() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //读文件
            fis = new FileInputStream("/Users/huangjie/Desktop/IO/idea快捷键.jpg");
            //写文件
            fos = new FileOutputStream("/Users/huangjie/Desktop/IO/dea快捷键copy.jpg");
            byte[] b = new byte[1024];
            int n = 0;
            //文件读取
            while ((n = fis.read(b)) != -1) {
                //文件拷贝(方式1)
                //fos.write(b);
                //保证拷贝的文件和原文件一样大(方式2)
                fos.write(b, 0, n);
            }
            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*
     * 缓冲流:BufferedOutputStream,BufferedInputStream
     * */
    @Test
    void testFour() {
        try {
            //输出流(写)
            FileOutputStream fos = new FileOutputStream("/Users/huangjie/Desktop/IO/score.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            //输入流(读)
            FileInputStream fis = new FileInputStream("/Users/huangjie/Desktop/IO/score.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            //写操作,此时还是写到缓冲区中,并没有写到文件里面
            bos.write(50);
            bos.write('a');
            //缓冲区写入文件
            bos.flush();
            //读操作
            System.out.println(bis.read());
            System.out.println((char) bis.read());
            //System.currentTimeMillis();
            fos.close();
            bos.close();
            fis.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     *  字节流和字节缓冲流的对比案例
     * */
    @Test
    void testDemo1() {
        /*
         * 低级流
         * */
        {
            try {
                //读
                FileInputStream fis = new FileInputStream("/Users/huangjie/Desktop/IO/" +
                        "大话设计模式(带目录完整版).pdf");
                //写
                FileOutputStream fos = new FileOutputStream("/Users/huangjie/Desktop/IO/" +
                        "大话设计模式(带目录完整版)copy.pdf");
                //定义字节数组
                byte[] b = new byte[1024];
                //定义一个初始化变量
                int n = 0;
                //拷贝之前记录系统时间
                long startTime = System.currentTimeMillis();
                while ((n = fis.read(b)) != -1) {
                    //写入,里面的n可以保证拷贝的文件和原文件一样大
                    fos.write(b, 0, n);
                }
                //拷贝完成后记录系统时间
                long endTime = System.currentTimeMillis();
                System.out.println("低级流一共花费时间为:" + (endTime - startTime));

                //关闭流
                fis.close();
                fos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
         * 高级流
         * */
        {
            try {
                //读
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/huangjie/Desktop/IO/" +
                        "大话设计模式(带目录完整版).pdf"));
                //写
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/huangjie/Desktop/IO/" +
                        "大话设计模式(带目录完整版)copy2.pdf"));
                int n = 0;
                byte[] b=new byte[1024];
                //拷贝之前记录系统时间
                long startTime = System.currentTimeMillis();
                while ((n = bis.read(b)) != -1) {
                    bos.write(b,0,n);
                    bos.flush();
                }
                //拷贝完成后记录系统时间
                long endTime = System.currentTimeMillis();
                System.out.println("高级一共花费时间为:" + (endTime - startTime));
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
