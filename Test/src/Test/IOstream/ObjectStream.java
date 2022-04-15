package Test.IOstream;

import org.junit.Test;

import java.io.*;

/**
 * @author Mr.xu
 * @create 2022/03/20/14:04
 * Description:
 */
public class ObjectStream {
    @Test
    public void test(){

        String str = new String("sfdfdff");
        byte[] b = str.getBytes();
        for (byte be :b){

            System.out.println(be);
        }

        ObjectOutputStream ous = null;
        ObjectInputStream ois = null;
        try {
            ous = new ObjectOutputStream(new FileOutputStream(new File("obj.dat")));
            ois = new ObjectInputStream(new FileInputStream(new File("obj.dat")));
            ous.writeObject(new Person("李华",22));
            Object obj1 = ois.readObject();
            System.out.println(obj1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ous != null) {
                try {
                    ous.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }}
