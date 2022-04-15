package gege.web;

import gege.pojo.page;
import gege.service.BookService;
import gege.service.impl.BookServiceImpl;
import gege.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.xu
 * @create 2022/04/01/12:28
 * Description:
 */
public class ClientBookServlet extends BaseServlet{


    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNO、pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), page.PAGE_SIZE);
        //2、调用bookService.page(pageNo,pageSize)方法
        page page = bookService.page(pageNo, pageSize);
        //设置分页地址
        page.setUrl("client/bookServlet?action=page");
        //3、保存到request域中
        req.setAttribute("page",page);
        //4、请求转发到
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNO、pageSize,min.max
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        //2、调用bookService.page(pageNo,pageSize)方法
        page page = bookService.pageByPrice(pageNo, pageSize,min,max);
        //设置分页地址
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格参数，追加到分页条的地址中
        if (req.getAttribute("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大价格参数，追加到分页条的地址中
        if (req.getAttribute("max") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3、保存到request域中
        req.setAttribute("page",page);
        //4、请求转发到
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }

}
