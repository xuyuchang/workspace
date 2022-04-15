package Test;

/**
 * @author Mr.xu
 * @create 2022/03/17/21:32
 * Description:
 */

public class EnumTest {
    public static void main(String[] args) {
        EnumTest t =  new EnumTest();
        star en = star.LIU;
        System.out.println(en.toString());
    }


}


enum star{
    LIU("刘德华",45),
    LI("李白",100),
    ZHANG("张学友",44),
    ZHOU("周润发",50);

    private String name;
    private int age;

    star(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

