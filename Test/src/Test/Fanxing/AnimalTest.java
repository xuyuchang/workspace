package Test.Fanxing;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Mr.xu
 * @create 2022/03/19/10:23
 * Description:
 */
public class AnimalTest {

    @Test
    public void Test1(){
        Animal<String> pig = new Animal<>("猪猪",2,"猪会吃饭");
        String str = pig.getE();
        System.out.println(str);

        Cat cat = new Cat("花花",3,"花花是一直好看的蓝猫");
        System.out.println(cat.getE());
        Dog<String> dog = new Dog<>("大黄",2,"大黄每天跟着肖主任到处跑");
        System.out.println(dog.getE());

        copy<Integer> cop = new copy<>();
        Integer[] inte = new Integer[]{2,3,354,5,5};
        ArrayList list1 = (ArrayList) cop.copy11(inte);
        System.out.println(list1);
    }

}
