package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    void deleteById(Integer id);

    Optional<Blog> findById(Integer id);

    Page<Blog> findAllPaging(String keyword, Pageable pageable);

    Page<Blog> findAllBlog(Pageable pageable);
}
