package Test;



import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Mr.xu
 * @create 2022/03/17/20:21
 * Description:
 */
public class Person  implements Serializable {
    private static final long serialVersionUID = -6849794470724667710L;
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Person[] p = new Person[4];
        p[1] = new Person("a",22);
        p[2] = new Person("b",24);
        p[3] = new Person("c",22);
        p[0] = new Person("d",23);
                Arrays.sort(p, new Comparator() {

                    @Override
                    public int compare(Object o1, Object o2) {
                        if (o1 instanceof Person && o2 instanceof Person) {
                            Person p1 = (Person) o1;
                            Person p2 = (Person) o2;
                            if (p1.getName().equals(p2.getName())) {
                                return Double.compare(p1.getAge(), p2.getAge());
                            } else {
                                return p1.getName().compareTo(p2.getName());
                            }
                        } else {
                            throw new RuntimeException("数据类型不一致");
                        }
                    }

                });
        System.out.println(Arrays.toString(p));


            }
        }


