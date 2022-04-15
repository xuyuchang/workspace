package gege.service.impl;

import gege.dao.BookDao;
import gege.dao.impl.BookDaoImpl;
import gege.pojo.Book;
import gege.pojo.page;
import gege.service.BookService;

import java.util.List;

/**
 * @author Mr.xu
 * @create 2022/03/30/20:22
 * Description:
 */
public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryById(Integer id) {
        return bookDao.queryById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public page<Book> page(int pageNo, int pageSize) {
        page<Book> page = new page<>();


        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页数
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        //设置总页数
        page.setPageTotal(pageTotal);


        //设置当前页码数
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;

        //球当前页数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);

        return page;
    }

    @Override
    public page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        page<Book> page = new page<>();


        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页数
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0){
            pageTotal++;
        }
        //设置总页数
        page.setPageTotal(pageTotal);


        //设置当前页码数
        page.setPageNo(pageNo);

        int begin = (page.getPageNo() - 1) * pageSize;

        //球当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);

        return page;
    }
}
