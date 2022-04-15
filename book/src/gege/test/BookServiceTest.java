package gege.test;

import gege.pojo.Book;
import gege.service.BookService;
import gege.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Mr.xu
 * @create 2022/03/30/20:25
 * Description:
 */
public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"大家好","徐玉昌",new BigDecimal(333),210,333,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryById() {
        System.out.println( bookService.queryById(23));
    }

    @Test
    public void queryBooks() {
    }
}