package gege.test;

import gege.dao.BookDao;
import gege.dao.impl.BookDaoImpl;
import gege.pojo.Book;

import java.math.BigDecimal;

/**
 * @author Mr.xu
 * @create 2022/03/30/19:58
 * Description:
 */
public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @org.junit.Test
    public void addBook() {
        Book book = new Book(null,"大家好","徐玉昌",new BigDecimal(333),210,333,"static/img/1.jpg");
        bookDao.addBook(book);
        System.out.println("push");

    }

    @org.junit.Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @org.junit.Test
    public void updateBook() {
    }

    @org.junit.Test
    public void queryById() {
        Book book = bookDao.queryById(21);
        System.out.println(book);
    }

    @org.junit.Test
    public void queryBooks() {
//        for (Book book:bookDao.queryBooks()){
//            System.out.println(book);
//        }
//        bookDao.queryBooks().forEach(System.out::println);
        System.out.println(bookDao.queryBooks().toString());
    }


}