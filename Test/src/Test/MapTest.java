package Test;

import org.junit.Test;

import java.util.*;

/**
 * @author Mr.xu
 * @create 2022/03/19/14:41
 * Description:
 */
public class MapTest {

    @Test
    public void test2(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("张三",22);
        map.put("周杰伦",33);
        map.put("周笔畅",32);
        map.put("大张伟",32);
        map.put("郭富城",45);
        map.put("沈腾",44);
        map.put("玛丽",43);
        map.put("谢霆锋",33);
        //遍历key
        Set<String> key = map.keySet();
        for (String str:key){
            System.out.println(str);
        }
        //遍历values
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }
        //遍历kye--values
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entry.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String, Integer> next = iterator1.next();
            System.out.println(next.getKey() + "----->" + next.getValue());

        }    }}
