package Test.IOstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Mr.xu
 * @create 2022/03/20/10:37
 * Description:
 */
public class Systemin {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true){
            System.out.println("请输入字符串");
            String str = br.readLine();
            if ("e".equalsIgnoreCase(str ) || "exit".equalsIgnoreCase(str )){
                break;
            }else{
                System.out.println(str.toUpperCase());

            }
        }
        if (br != null){

            br.close();
        }
    }
}
