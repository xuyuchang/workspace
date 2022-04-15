package Test.IOstream;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author Mr.xu
 * @create 2022/03/19/22:03
 * Description:
 */
public class Count {
    @Test
    public void CountWorld()  {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("count.txt")));
            HashMap<Character, Integer> map = new HashMap<>();
            char[] chars  = new char[1];
            while (br.read(chars) != -1){
                if (! map.containsKey(chars[0])){
                    map.put(chars[0],1);
                }else{

                    Integer key = map.get(chars[0]);
                    map.put(chars[0],key + 1);
                }


            }
            Set<Map.Entry<Character, Integer>> entries = map.entrySet();
           // Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
            for (Map.Entry<Character, Integer> entry: entries){
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格 " + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行 " + entry.getValue());
                        break;
                    case '\t':
                        bw.write("TAB键 " + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车 " + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + " " + entry.getValue());
                }
                bw.newLine();
            }
//            while (iterator.hasNext()){
//                Map.Entry<Character, Integer> next = iterator.next();
//                char char1 = next.getKey();
//                Integer char2 = next.getValue();
//                String str = char1 + "  " + char2;
//                bw.write(str);
//                bw.newLine();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
