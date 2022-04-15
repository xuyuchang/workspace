package Test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/14:27
 * Description:
 */
public class StringSort {

    public static void main(String[] args) {
        String s  = "12343";
        StringSort  st = new StringSort();
        char [] c = st.strsort(s);
        String s1 = String.valueOf(c);
        System.out.println(s1.toString());
        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i));
        }

    }

    public char[] strsort(String str){
        char chars[] = str.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length -1 -i; j++) {
                if(chars[j] > chars[j + 1]){
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }

            }
        }
        return chars;
    }

}

