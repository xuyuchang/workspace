package gege.web;

import com.google.gson.Gson;
import gege.pojo.User;
import gege.service.UserService;
import gege.service.impl.UserServiceImpl;
import gege.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author Mr.xu
 * @create 2022/03/29/22:28
 * Description:
 */
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    //处理login的请求
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        //调用userservice().Login()方法处理登录业务
        User login = userService.login(new User(null, username, password, null));
        //等于null说明登录失败
        if (login == null) {
            //把错误信息和返回的表单项，保存在request域中

            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            //跳回登陆页面
            try {
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //保存用户登录成功之后的信息到session域中
            req.getSession().setAttribute("user",login);
            //登录成功返回/pages/user/login_success.jsp页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    //注销
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、销毁session
        req.getSession().invalidate();
        //2、重定向index.jsp
        resp.sendRedirect(req.getContextPath());
    }


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        //userservice.existsUesername()
        boolean existsUsername = userService.existsUsername(username);
        //把返回的结果封装为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("username",existsUsername);

        Gson gson = new Gson();
        String s = gson.toJson(resultMap);
        resp.getWriter().write(s);
    }
    //处理register的请求
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");



        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                //把回显信息保存在request域中
                req.setAttribute("msg", "用户名已经存在");

                req.setAttribute("username", username);
                req.setAttribute("email", email);
                System.out.println("验证码{" + code + "}错误");
                System.out.println("用户名[" + username + "]已经存在");
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            } else {
                userService.registUser(new User(null, username, password, email));
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
            }


        } else {
            //把回显信息保存在request域中
            WebUtils.copyParamToBean(req.getParameterMap(),new User());
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            System.out.println("验证码{" + code + "}错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }



}
