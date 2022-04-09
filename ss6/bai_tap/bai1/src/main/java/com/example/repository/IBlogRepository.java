package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findAllById(Integer id, Pageable pageable);

    Page<Blog> findAllByOrderById(Pageable pageable);
}
