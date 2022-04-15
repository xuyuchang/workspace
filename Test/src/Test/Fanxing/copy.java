package Test.Fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.xu
 * @create 2022/03/19/10:48
 * Description:
 */
public class copy<T> {
    public <T> List< T > copy11(T[]e){
        ArrayList<T> list = new ArrayList<>();
        for (T t : e) {
            list.add(t);
        }
        return list;

    }
}
