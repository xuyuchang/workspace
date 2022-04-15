package Test.Fanxing;

/**
 * @author Mr.xu
 * @create 2022/03/19/10:03
 * Description:
 */
public class Animal <E>{
    private String name;
    private int age;

    E e ;

    public Animal(String name, int age, E e) {
        this.name = name;
        this.age = age;
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}


