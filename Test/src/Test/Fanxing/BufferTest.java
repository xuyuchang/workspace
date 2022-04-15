package Test.Fanxing;

import org.junit.Test;

import java.io.*;

/**
 * @author Mr.xu
 * @create 2022/03/19/20:00
 * Description:
 */
public class BufferTest {
    @Test
    public void test()  {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            File file1 = new File("11.jpg");
            File file2 = new File("1.jpg");
            FileInputStream fi = new FileInputStream(file1);
            FileOutputStream fo = new FileOutputStream(file2);
            bi = new BufferedInputStream(fi);
            bo = new BufferedOutputStream(fo);
            byte[] bytes = new byte[5];
            int len;
            while ((len = bi.read(bytes) )!= -1){
                bo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void bufferCopy(String src,String dest){
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            File file1 = new File(src);
            File file2 = new File(dest);
            FileInputStream fi = new FileInputStream(file1);
            FileOutputStream fo = new FileOutputStream(file2);
            bi = new BufferedInputStream(fi);
            bo = new BufferedOutputStream(fo);
            byte[] bytes = new byte[5];
            int len;
            while ((len = bi.read(bytes) )!= -1){
                bo.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bi != null) {
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bo != null) {
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void test2(){
        String str1 = "C:\\Users\\xyc14\\Desktop\\1.pptx";
        String str2 = "C:\\Users\\xyc14\\Desktop\\1copy.pptx";
        bufferCopy(str1,str2);

    }}
