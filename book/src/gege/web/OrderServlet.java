package gege.web;

import gege.pojo.Cart;
import gege.pojo.User;
import gege.service.OrderService;
import gege.service.impl.OrderServiceImpl;
import gege.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.xu
 * @create 2022/04/02/17:11
 * Description:
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();


    //创建购物车对象
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取userId
        User loginUser = (User) req.getSession().getAttribute("user");
        if (loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId = loginUser.getId();
        //调用orderService.createOrder()生成订单
        String orderId = null;
        try {
            orderId = orderService.createOrder(cart, userId);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把错误抛给Tomcat服务器
        }
        //把订单号保存到request域中
        req.getSession().setAttribute("orderId",orderId);
        //req.setAttribute("orderId",orderId);
        //请求转发到pages/cart/chechout.jsp
        //req.getRequestDispatcher("pages/cart/checkout.jsp").forward(req,resp);

        resp.sendRedirect("pages/cart/checkout.jsp");

    }
}
