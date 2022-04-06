package com.codegym.repository.impl;


import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {

        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public void update(Integer id, Product product) {

    }

    @Override
    public void remove(Integer id) {

    }
}
