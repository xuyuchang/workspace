package gege.service.impl;


import gege.dao.UserDao;
import gege.dao.impl.UserDaoImpl;
import gege.pojo.User;
import gege.service.UserService;

/**
 * @author Mr.xu
 * @create 2022/03/28/10:38
 * Description:
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.SaveUser(user);

    }

    @Override
    public User login(User user) {
        return userDao.QueryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.QueryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
