package Test.TcpIp;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Mr.xu
 * @create 2022/03/20/16:33
 * Description:
 */
public class ServerClient {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket("127.0.0.1", 3434);
            os = socket.getOutputStream();
            os.write("你好，我是客户端1".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void server()  {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream bo = null;
        try {
            serverSocket = new ServerSocket(3434);
            socket = serverSocket.accept();
            is = socket.getInputStream();
            bo = new ByteArrayOutputStream();
            byte[] bt = new byte[6];
            int len;
            while ((len = is.read(bt)) != -1){
                bo.write(bt, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            System.out.println(bo.toString());
            try {
                bo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

