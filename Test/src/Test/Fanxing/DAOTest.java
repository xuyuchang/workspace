package Test.Fanxing;

import org.junit.Test;

import java.util.List;

/**
 * @author Mr.xu
 * @create 2022/03/19/13:52
 * Description:
 */
public class DAOTest {
    @Test
    public void test1(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1001",new User(1001,33,"周揭露"));
        userDAO.save("1002",new User(1003,33,"段意"));
        userDAO.save("1003",new User(1441,33,"王杰"));
        List<User> list = userDAO.list();
        System.out.println(list);
        User user = userDAO.get("1001");
        System.out.println(user);
        userDAO.delete("1001");
        List<User> list1 = userDAO.list();
        System.out.println(list1);
    }

}
