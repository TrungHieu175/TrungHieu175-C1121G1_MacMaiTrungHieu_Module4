package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    void deleteById(Integer id);

    Blog findById(Integer id);
}
