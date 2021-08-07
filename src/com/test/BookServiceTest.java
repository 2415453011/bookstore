package com.test;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author xjm
 * @create 2020-04-25 18:49
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"明哥","xjm",new BigDecimal(9999),9999,0,null));
    }

    @Test
    public void deleteBookId() {
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(23,"帅哥","ddd",new BigDecimal(500),999,999,null));
    }

    @Test
    public void queryBookById() {
        bookService.deleteBookId(22);
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookService.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice(){

        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,0,99));
    }
}