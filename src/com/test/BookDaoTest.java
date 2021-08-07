package com.test;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import com.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author xjm
 * @create 2020-04-22 23:33
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"Gary","xjm",new BigDecimal(9999),9999,999,null));
    }

    @Test
    public void deleteBookId() {
        bookDao.deleteBookId(22);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(23,"暴富1","徐佳明",new BigDecimal(99999),99999,0,null));
    }

    @Test
    public void queryBookId() {
        System.out.println(bookDao.queryBookId(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book queryForPageItem : bookDao.queryForPageItems(4, 3)) {
            System.out.println(queryForPageItem);
        }
    }
    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(0,99));
    }
    @Test
    public void queryForPageItemsByPrice() {
        for (Book queryForPageItemByPrice : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,0,99)) {
            System.out.println(queryForPageItemByPrice);
        }
    }
}