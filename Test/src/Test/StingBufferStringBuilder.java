package Test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/20:27
 * Description:
 */
public class StingBufferStringBuilder {

    public static void main(String[] args) {

        String s = "1224556789";
        String ss = s.substring(0,2);
        System.out.println(ss);
        StingBufferStringBuilder sb = new StingBufferStringBuilder();
        StringBuilder s2 = sb.reverse3(s,3,6);
        System.out.println(s2);

    }


    public String reverse1(String str,int start,int end){
        char[] chars = str.toCharArray();
        for (int x = start - 1 ,y = end - 1;x < y;x++,y--) {

            char temp = chars[x];
            chars[x ] = chars[y];
            chars[y] = temp;

        }
        String str1 = String.valueOf(chars);
        return str1;
    }

    public String reverse2(String str,int start,int end) {
        String str1 = str.substring(0,start -1);
        for (int i = end - 1; i >= start; i--) {
            str1 += str.charAt(i);
        }
       str1 += str.substring(end);
        return  str1;
    }



    public StringBuilder reverse3(String str,int start,int end) {
        StringBuilder str1 = new StringBuilder(str.length());
        str1.append(str.substring(0,start - 1));
        for (int i = end - 1; i >= start; i--) {
            str1.append(str.charAt(i));
        }
        str1.append(str.substring(end ));
        return  str1;
    }


    @Test
    public void tt() throws ParseException {
        StringBuffer s1 = new StringBuffer("123455");
        s1.append("efef");
        System.out.println(s1);


        Date date = new Date();
        String sss = date.toString();
        System.out.println(sss);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss");
        System.out.println(date);
        String str1 = simpleDateFormat.format(date);
        System.out.println(str1);
       Date date1 = simpleDateFormat.parse(str1);
        System.out.println(date1);
//        String str = "Thu Mar 17 10:15:18 GMT+08:00 2022";
//
//           String str1 = simpleDateFormat.format(str );
//            System.out.println(str1);
//
//        System.out.println(date);
    }}
