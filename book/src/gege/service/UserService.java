package gege.service;

import gege.pojo.User;

/**
 * @author Mr.xu
 * @create 2022/03/28/10:32
 * Description:
 */
public interface UserService {


    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null登陆失败
     */
    public User login(User user);


    /**
     * 检查用户名是否可用
     * @param username
     * @return
     */
    public boolean existsUsername(String username);
}
