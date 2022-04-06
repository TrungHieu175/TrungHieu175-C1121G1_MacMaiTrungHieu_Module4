package com.codegym.repository.impl;


import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        String sql = "select p from product p";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(sql, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (product.getId() == null){
            BaseRepository.entityManager.persist(product);
        } else {
            BaseRepository.entityManager.merge(product);
        }
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public void update(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = findById(id);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
