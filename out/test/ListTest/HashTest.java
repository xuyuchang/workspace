import java.util.*;

/**
 * @author Mr.xu
 * @create 2022/03/18/19:19
 * Description:
 */
public class HashTest {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1,23);
        map.put(2,"23");
        map.put(3,"你好");
        map.put(4,new Date());
        System.out.println(map);
        map.remove(1,22);
        System.out.println(map );
        map.remove(1,23);
        System.out.println(map);
        LinkedHashMap lhash = new LinkedHashMap(22);
        lhash.putAll(map);
        System.out.println(lhash);
        System.out.println(lhash.get(3));;
        lhash.replace(2,23,44);
        System.out.println(lhash);
        lhash.clear();
        System.out.println(lhash.values());
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        Collection values = map.values();
        for (Object boj:values){
            System.out.println(boj);
        }

        Set set1 = map.entrySet();
        for (Object obj : set1){
            System.out.println(set1);
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "------>" + entry.getValue());
        }
    }
}
