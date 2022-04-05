package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);
    void update(Blog blog,Integer id);

    Blog findById(Integer id);

    void deleteById(Integer id);
}
