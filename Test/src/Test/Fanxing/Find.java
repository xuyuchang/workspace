package Test.Fanxing;

/**
 * @author Mr.xu
 * @create 2022/03/19/12:14
 * Description:
 */
public class Find <E>{
    E e;

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public Find() {
    }

    public Find(E e) {
        this.e = e;
    }
    public void show(){
        System.out.println("我是泛型：" + e.getClass());

    }
}
