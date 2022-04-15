package Test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/12:38
 * Description:字符串指定位置反转
 */
public class Stringnb {
    public static void main(String[] args) {

        Stringnb ss = new Stringnb();
        String str = "abcdefj";
        String restr = reverse2(str,2,5);
        System.out.println(restr);
    }

    //方式一：
    public String reverse1(String str,int start,int end){
        //将字符串转换为字符数组
        char[] arr = str.toCharArray();
        //遍历字符数组
        for (int x = start,y = end; x < y; x++,y--) {
            //交换指定范围内的数值
            char temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }
        //将字符数组转换为字符串
        return new String(arr);
    }
    //方式二：使用String拼接
    public static String reverse2(String str, int start, int end){
        //第一部分，使用String的substring()进行拼接第一部分
        String reverseStr = str.substring(0,start);
        //第二部分,从后往前遍历，将需要反转的范围拼接一起
        for (int i = end; i > start ; i--) {
            reverseStr += str.charAt(i);
        }
        //第三部分，将后面部分继续使用substring()拼接
        reverseStr += str.substring(end);
        return reverseStr;

    }
}

