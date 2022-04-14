package com.example.service;

import com.example.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    void deleteById(Integer id);

    Optional<Category> findById(Integer id);
}
