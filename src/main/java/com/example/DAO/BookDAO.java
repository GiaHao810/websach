package com.example.DAO;

import java.util.List;

import com.example.model.Book;

public interface BookDAO {

    public int add(Book book);

    public int update(Book book);

    public int deleted(int id);

    public Book getBookByID(Integer id);

    public List<Book> getAllBook();

}
