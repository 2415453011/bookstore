package com.service;

import com.pojo.Book;
import com.pojo.Page;

import java.util.List;

/**
 * @author xjm
 * @create 2020-04-25 18:09
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookId(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo,int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
