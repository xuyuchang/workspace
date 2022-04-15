import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Mr.xu
 * @create 2022/03/18/13:47
 * Description:循环打印列表的三种方式
 */
public class ListTest1 {


    public static void main(String[] args) {
        ArrayList list = new ArrayList(4);
        list.add("AA");
        list.add(123);
        list.add(456);
        list.add(new Date());
        ArrayList list1 = new ArrayList();
        list1.addAll(list);
        list1.set(1,222);
        list1.remove("AA");
        System.out.println(list1);
        LinkedList llist = new LinkedList();
        llist.addAll(list);
        System.out.println(llist);

        //方式一：迭代器iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //方式二：foreach()
        for (Object obj:list){
            System.out.println(obj);
        }

        //方式三：普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
