package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public Page<Blog> findAllPaging(String keyword, Pageable pageable) {
        return iBlogRepository.findAllByContentContaining(keyword, pageable);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return iBlogRepository.findAllByOrderById(pageable);
    }
}
