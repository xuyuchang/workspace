package Test;

/**
 * @author Mr.xu
 * @create 2022/03/{DAY}/13:15
 * Description:去两个字符串最大相同子串
 */
public class maxString {
    public static void main(String[] args) {
        maxString ms = new maxString();
        String s1 =  "abcdefg";
        String s2 = "abceg";
        String s3 = ms.getSameString(s1,s2);
        System.out.println(s3);
    }


    public static String getSameString(String str1, String str2) {
        if(str1 != null && str2 != null){

            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();

            for (int i = 0; i < length; i++) {

                for (int x = 0, y = length-i; y <= length; x++, y++) {
                    if (maxStr.contains(minStr.substring(x, y))) {
                        return minStr.substring(x, y);
                    }
                }

            }

        }
        return null;
    }


//public String MaxSub(String str1,String str2){
//
//    String result = "";
//    int length = str2.length();
//    for (int i = 0; i < length; i++) {
//        if (str1.contains(str2)){
//            result = str2;
//            break;
//
//
//        }else{
//            str2 = str2.substring( 1);
//            //System.out.println(str2);
//        }
//        //result = result1;
//    }
//    for (int i = 0; i < str2.length(); i++) {
//        if (str1.indexOf(str2) != -1){
//            result1 = str2;
//
//        }else{
//            str2 = str2.substring(0,str2.length() - 1);
//        }
//        result = result1;
//    }
//    return result;
//}
}