package com.goosuu.code13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端:
 *    构造方法：
 *      ServerSocket(int port)
 *      Socket accept():获取客户端连接
 *
 *
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9501);
        Socket socket = ss.accept();
        //接收客户端发送数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = is.read(bytes))!=-1) {
//            System.out.println(len);
            System.out.println(new String(bytes,0,len));
        }

        //向客户端发送数据
        OutputStream os = socket.getOutputStream();
        os.write("World".getBytes());

        socket.close();
        ss.close();

    }
}
