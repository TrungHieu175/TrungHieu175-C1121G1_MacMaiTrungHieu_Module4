package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    void deleteById(Integer id);

    Blog findById(Integer id);

    Page<Blog> findAllById (Integer keyword, Pageable pageable);

    Page<Blog> findAllOderBy (Pageable pageable);
}
