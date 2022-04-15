package Test.Fanxing;

import java.util.*;

/**
 * @author Mr.xu
 * @create 2022/03/19/13:39
 * Description:
 */
public class DAO<T> {
    private Map<String,T> map = new HashMap<>();
    public void save(String id,T entry){
        map.put(id,entry);
    }

    public T get(String id){
        return map.get(id);
    }

    public void upDate(String id,T entry){
        map.replace(id,entry);
    }

    public List<T> list(){
        Collection<T> values = map.values();

        ArrayList<T> ts = new ArrayList<>();
        for (T t:values){
            ts.add(t);
        }
        return ts;
    }

    public void delete(String id){
        map.remove(id);
    }
}
