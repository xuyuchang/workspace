import java.util.*;

/**
 * @author Mr.xu
 * @create 2022/03/18/15:42
 * Description:
 */
public class ListOrTreeset {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        System.out.println(list);
       // ListOrTreeset ls = new ListOrTreeset();
        List list1 = hash(list);
        System.out.println(list1);
        for (Object obj:list1){
            System.out.println(obj);
        }
    }


    public static List hash(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return  new ArrayList(set);
    }
}
