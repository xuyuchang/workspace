package Test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/11:27
 * Description:一个字符串在另一个中出现在另一个中的次数
 */
public class StringSum {
    public static void main(String[] args) {

        String s1 = "nla";
        String s2 = "nlanlanlanlcfdvdvsvanlnl";
        StringSum ss = new StringSum();
        int sum = ss.StringSunm(s2,s1);
        System.out.println(sum);

    }
    public int StringSunm(String str1,String str2){
        int sum = 0;
        while(str1.indexOf(str2) != -1){
            int index = str1.indexOf(str2);
            sum++;
            str1 = str1.substring(index + str2.length());

        }
        return sum;

    }
}


