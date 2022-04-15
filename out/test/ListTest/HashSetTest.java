import java.util.HashSet;
import java.util.Objects;

/**
 * @author Mr.xu
 * @create 2022/03/18/15:27
 * Description:
 */
public class HashSetTest {

    public static void main(String[] args) {
        HashSetTest hs = new HashSetTest();
        person p1 = new person("AA",22);
        person p2 = new person("BB",34);
        person p3 = new person("CC",33);
        person p4 = new person("GG",21);
        HashSet hashSet = new HashSet();
        hashSet.add(p1);
        hashSet.add(p2);
        hashSet.add(p3);
        hashSet.add(p4);
        System.out.println(hashSet);
        p1.name = "FF";
        hashSet.remove(p1);
        System.out.println(hashSet);
        hashSet.add(new person("FF",22));
        System.out.println(hashSet);
    }
}


 class person{
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

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         person person = (person) o;
         return age == person.age &&
                 Objects.equals(name, person.name);
     }

     @Override
     public int hashCode() {
         return Objects.hash(name, age);
     }

     @Override
     public String toString() {
         return "person{" +
                 "name='" + name + '\'' +
                 ", age=" + age +
                 '}';
     }

     public person(String name, int age) {
         this.name = name;
         this.age = age;
     }

     public void setAge(int age) {
        this.age = age;
    }

    public person() {
    }
}