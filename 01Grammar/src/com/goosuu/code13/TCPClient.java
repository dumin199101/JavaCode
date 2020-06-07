package com.goosuu.code13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *  TCP客户端:
 *    构造方法：Socket(String host,int port)
 *    成员方法：
 *       close()
 *       getInputStream()
 *       getOutputStream()
 *       shutdownOutput()
 *
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9501);
        //获取输出流对象，向服务器发送数据
        OutputStream os = socket.getOutputStream();
        os.write("Hello".getBytes());
        //加入shutdownOutput，否则服务端read()方法一直等待客户端发送数据
        socket.shutdownOutput();
        //获取输入流对象读取服务器端数据
        InputStream is = socket.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        socket.close();




    }
}
