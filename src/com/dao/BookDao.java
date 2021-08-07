package com.dao;

import com.pojo.Book;

import java.util.List;

/**
 * @author xjm
 * @create 2020-04-22 23:18
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookId(Integer id);

    public int updateBook(Book book);

    public Book queryBookId(Integer id);

    public List<Book> queryBooks();


    Integer queryForPageTotalCount();


    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
