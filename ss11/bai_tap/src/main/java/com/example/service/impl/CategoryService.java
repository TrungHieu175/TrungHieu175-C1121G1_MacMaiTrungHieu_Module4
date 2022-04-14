package com.example.service.impl;

import com.example.model.Category;
import com.example.repository.ICatrgoryRepository;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICatrgoryRepository iCatrgoryRepository;

    @Override
    public List<Category> findAll() {
        return iCatrgoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        iCatrgoryRepository.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        iCatrgoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return iCatrgoryRepository.findById(id);
    }
}
