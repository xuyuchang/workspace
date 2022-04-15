package gege.dao.impl;


import gege.dao.UserDao;
import gege.pojo.User;

/**
 * @author Mr.xu
 * @create 2022/03/27/21:40
 * Description:
 */
public class UserDaoImpl extends gege.dao.impl.BaseDao implements UserDao {
    @Override
    public User QueryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User QueryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);

    }

    @Override
    public int SaveUser(User user) {
        String sql = "insert into t_user(username,password,email)values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    public static void main(String[] args) {
        UserDaoImpl ud = new UserDaoImpl();
        System.out.println(ud.QueryUserByUsername("admin"));
        User user = new User(2,"徐徐","888888","xu@126.email");
        ud.SaveUser(user);
    }

}
