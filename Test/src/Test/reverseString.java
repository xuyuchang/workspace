package Test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/10:43
 * Description:字符串指定位置反转
 */
public class reverseString {


    public static void main(String[] args) {
        reverseString re  = new reverseString();
        String str = "abcdefg";
        String s1 = re.reversNew(str,1,4);
        System.out.println(s1);
    }


    public String reversNew(String str,int start,int end){
       String newStr = "";
       char[] chars = str.toCharArray();
        for (int i = 0; i < start - 1; i++) {
            newStr += chars[i];
        }
        for (int i = start - 1; i < end; i++) {
            newStr += chars[end - 1 - i];
        }
        for (int i = end ; i < str.length(); i++) {
            newStr += chars[i];

        }
        return newStr;
    }
}


