package com.dm.login.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WxUtil {

    /**
     * 向指定的地址发送get请求
     * @param url
     * @return
     */
    public static String get(String url){
        try {
            URL urlObject = new URL(url);
            //开始连接
            URLConnection connection = urlObject.openConnection();
            return getInput(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送请求
     * @param url
     * @param data
     * @return
     */
    public static String post(String url,String data){
        try {
            //1.创建连接对象
            URL urlObject = new URL(url);
            //2.建立连接
            URLConnection connection = urlObject.openConnection();
            //3.要发送数据出去、必须要设置为可发送数据状态
            connection.setDoOutput(true);
            //4.获取输出流
            OutputStream os = connection.getOutputStream();
            //5.写出数据
            if(data!=null){
                os.write(data.getBytes());
                os.close();
            }

            return getInput(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getInput(URLConnection connection){
        try {
            //获取输入流
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len=is.read(b))!=-1){
                //new String(数组,从下标开始,取长度,字符编码)
                sb.append(new String(b,0,len));
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




























}
