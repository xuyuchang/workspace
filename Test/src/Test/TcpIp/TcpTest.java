package Test.TcpIp;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Mr.xu
 * @create 2022/03/20/17:08
 * Description:传输一张图片到客户端
 */
public class TcpTest {
    //客户端
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        BufferedInputStream buffer = null;
        InputStream inputStream = null;
        ByteArrayOutputStream bi = null;
        try {
            socket = new Socket("127.0.0.1", 9090);
            outputStream = socket.getOutputStream();
            buffer = new BufferedInputStream(new FileInputStream(new File("11.jpg")));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = buffer.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            //关闭数据流输出
            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            bi = new ByteArrayOutputStream();
            while ((len = inputStream.read(bytes)) != -1){
                bi.write(bytes,0,len);

            }
            System.out.println(bi.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
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
    //服务器端
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream inputStream = null;
        BufferedOutputStream bo = null;
        OutputStream outputStream = null;
        try {
            ss = new ServerSocket(9090);
            socket = ss.accept();
            inputStream = socket.getInputStream();
            bo = new BufferedOutputStream(new FileOutputStream(new File("22.jpg")));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                bo.write(buffer,0,len);
            }
            outputStream = socket.getOutputStream();
            outputStream.write("你好，图片已经收到了，很好看".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
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
            }if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (outputStream != null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }
}
