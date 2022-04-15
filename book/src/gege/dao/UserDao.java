package gege.dao;


import gege.pojo.User;

/**
 * @author Mr.xu
 * @create 2022/03/27/21:34
 * Description:
 */
public interface UserDao  {
    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    public User QueryUserByUsername(String username);

    /**
     * 通过用户名和密码查询用户
     * @param username
     * @return
     */
    public User QueryUserByUsernameAndPassword(String username,String password);


    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int SaveUser(User user);

}
