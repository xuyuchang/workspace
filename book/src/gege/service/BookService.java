package gege.service;

import gege.pojo.Book;
import gege.pojo.page;

import java.util.List;

/**
 * @author Mr.xu
 * @create 2022/03/30/20:20
 * Description:
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryById(Integer id);

    public List<Book> queryBooks();

    public page<Book> page(int pageNo, int pageSize);

    page pageByPrice(int pageNo, int pageSize, int min, int max);
}
