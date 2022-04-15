package Test.Fanxing;

import org.junit.Test;

import java.io.*;

/**
 * @author Mr.xu
 * @create 2022/03/19/16:01
 * Description:
 */
public class FileTest {
    @Test
    public void test() {
        FileReader fi = null;
        FileWriter fw = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("hello1.txt");

            fi = new FileReader(file);
            fw = new FileWriter(file1,true);
//            int data = fi.read();
//            while (data != -1) {
//                System.out.print((char) data);
//                data = fi.read();
//
//            }
            char[] chars = new char[3];
            int len;
            while ((len = fi.read(chars)) != -1){
                //String str = new String(chars,0,len);
                fw.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi == null)
                    fi.close();
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
