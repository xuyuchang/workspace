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
 * @create 2022/03/28/10:50
 * Description:
 */
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        if("abcd".equalsIgnoreCase(code)){
            if (userService.existsUsername(username)){
                //把回显信息保存在request域中
                req.setAttribute("msg","用户名已经存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                System.out.println("验证码{"+ code + "}错误");
                System.out.println("用户名["+username +"]已经存在");
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
            }else {
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req,resp);
            }


        }else {
            //把回显信息保存在request域中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码{"+ code + "}错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
        }
    }
}
