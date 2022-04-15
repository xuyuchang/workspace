package Test;


import java.util.Arrays;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/20:37
 * Description:
 */
public class StringSumTest {


    public static void main(String[] args) {
        String str = new String("abddfoejfmgoeojf1");
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);

//
//        Integer[] int1 = new Integer[5];
//        int1[0] = 1;
//        int1[1] = 23;
//        int1[2] = 15;
//        Arrays.sort(int1);
//        for (int i = 0; i < int1.length; i++) {
//            System.out.println(int1[i]);
//        }


        String[] str2 = new String[6];
//        for (int i = 0; i < str2.length; i++) {
//            str2[i] = i + "nnnf";
//        }

        System.out.println(Arrays.toString(str2));
        Arrays.sort(str2);
        System.out.println(Arrays.toString(str2));
    }
}
