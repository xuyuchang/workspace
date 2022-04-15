package Test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/21:05
 * Description:
 */
public class StringTest {

    public static void main(String[] args) {
        String s1= "abc";
        String s2 = s1.replace('a','n');
        System.out.println(s1);
        System.out.println(s2);



        String str1 = "   abc  ";
        char[] char1 = str1.toCharArray();
        System.out.println(char1.toString());
        for (int i = 0; i < char1.length; i++) {
            System.out.println(char1[i]);
        }
    }
}
