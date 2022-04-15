package Test.Fanxing;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Mr.xu
 * @create 2022/03/19/16:50
 * Description:
 */
public class StreamTests {
    @Test
    public void test() {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file1 = new File("11.jpg");
            File file2 = new File("111.jpg");
            fi = new FileInputStream(file1);
            fo = new FileOutputStream(file2);
            byte[] bt = new byte[10];
            int len;
            while ((len = fi.read(bt)) != -1){
                fo.write(bt,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
