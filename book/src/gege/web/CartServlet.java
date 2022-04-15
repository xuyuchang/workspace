package gege.web;

import com.google.gson.Gson;
import gege.pojo.Book;
import gege.pojo.Cart;
import gege.pojo.CartItem;
import gege.service.BookService;
import gege.service.impl.BookServiceImpl;
import gege.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.xu
 * @create 2022/04/01/19:43
 * Description:
 */
public class CartServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();

    /**
     * 添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("加入购物车");
        //获取请求的参数 商品id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookservice.queryById查询图书
        Book book = bookService.queryById(id);
        //把图书转换为cartitemd对象
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用cartadd添加商品
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //保存最后添加商品的名字
        req.getSession().setAttribute("lastItemName",cartItem.getName());
        //重定向回商品列表
        resp.sendRedirect(req.getHeader("Referer"));

    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数 商品id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //调用bookservice.queryById查询图书
        Book book = bookService.queryById(id);
        //把图书转换为cartitemd对象
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //调用cartadd添加商品
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        //保存最后添加商品的名字
        req.getSession().setAttribute("lastItemName",cartItem.getName());
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());
        Gson gson = new Gson();
        String s = gson.toJson(resultMap);
        resp.getWriter().write(s);


    }

    /**
     * 删除指定商品
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取商品的id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
            //删除商品
            cart.deleteItem(id);
        }
        //重定向回商品列表
        resp.sendRedirect(req.getHeader("Referer"));

    }

    /**
     * 清空购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取购物车对象
                Cart cart = (Cart) req.getSession().getAttribute("cart");
                if (cart != null){
                    //清空购物车
                    cart.clear();
                }
        //重定向回商品列表
        resp.sendRedirect(req.getHeader("Referer"));


    }

    //更改购物车商品数量
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        int count = WebUtils.parseInt(req.getParameter("count"),1);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart != null){
          cart.updateCount(id,count);
        }
        //重定向回商品列表
        resp.sendRedirect(req.getHeader("Referer"));


    }
}
