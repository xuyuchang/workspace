package gege.web;

import gege.pojo.Book;
import gege.pojo.page;
import gege.service.BookService;
import gege.service.impl.BookServiceImpl;
import gege.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Mr.xu
 * @create 2022/03/30/20:38
 * Description:
 */
public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();


    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNO、pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"),page.PAGE_SIZE);
        //2、调用bookService.page(pageNo,pageSize)方法
        page page = bookService.page(pageNo, pageSize);
        //设置分页地址
        page.setUrl("manager/bookServlet?action=page");
        //3、保存到request域中
        req.setAttribute("page",page);
        //4、请求转发到
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }
        protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取请求的参数，封装成为book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、调用bookserice.add()保存图书
        bookService.addBook(book);
        //3、跳转到图书界面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");


    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 获取请求的参数id
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2 调用bookservice.delete()删除图书
        bookService.deleteBookById(id);
        //3 返回图书列表界面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数，封装成book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2、调用bookservice.update()方法，修改图书
        bookService.updateBook(book);
        //3、请求转发到/manager/bookservlet?action=list中
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");

    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //1、获取请求图书的编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //2、调用bookService.queryBookByid()方法查询图书
        Book book = bookService.queryById(id);
        //3、保存图书到request域中
        req.setAttribute("book",book);
        //4、请求转发到manager/bookServlet中
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、通过bookservice查询全部图书
        List<Book> books = bookService.queryBooks();
        //2、把全部图书保存到request域中
        req.setAttribute("books",books);
        //3、请求转发到pages/manager/book_manager.jsp中
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
