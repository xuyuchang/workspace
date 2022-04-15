package Test.Fanxing;

import org.junit.Test;

/**
 * @author Mr.xu
 * @create 2022/03/19/12:16
 * Description:
 */
public class FindTest {
    @Test
    public void Test11(){
        Find<String> find = new Find();
        find.setE("string");
        find.show();
        Find<Integer> find1 = new Find(22);
        Find<Dog> find2 = new Find(new Dog<String>("花花",22,"你好"));
        Find<Cat> find3 = new Find(new Cat("蓝猫",2,"我是蓝猫"));
        find1.show();
        find2.show();
        find3.show();


    }}
