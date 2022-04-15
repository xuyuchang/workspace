package gege.web;

import gege.pojo.User;
import gege.service.UserService;
import gege.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




/**
 * @author Mr.xu
 * @create 2022/03/28/16:38
 * Description:
 */
public class LoginServlet extends HttpServlet {


    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //调用userservice().Login()方法处理登录业务
        User login = userService.login(new User(null,username, password, null));
        //等于null说明登录失败
        if (login == null){
            //把错误信息和返回的表单项，保存在request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //跳回登陆页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}

