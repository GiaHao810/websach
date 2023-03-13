package com.example.DAO;

import java.util.List;

import com.example.model.Authors;

public interface AuthorsDAO {

    public int add(Authors authors);

    public int update(Authors authors);

    public int deleted(int id);

    public Authors getAuthorsByID(Integer id);

    public List<Authors> getAllAuthors();
}
