/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/10:31
 * Description:模拟trim方法，去除字符串首尾空格
 */
public class Trims {
    public static void main(String[] args) {
        Trims t = new Trims();
        String s = "   wfefe    ";
        String newStr = t.trims(s);
        System.out.println(newStr);
        System.out.println("你好");
    }




    public String trims(String str){
        String newStr = "";

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' '){
                newStr +=chars[i];

            }else{
                continue;
            }
        }
        return newStr;
    }
}
