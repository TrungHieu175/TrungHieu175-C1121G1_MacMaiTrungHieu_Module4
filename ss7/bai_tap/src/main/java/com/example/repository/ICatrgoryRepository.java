package com.example.repository;

import com.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatrgoryRepository extends JpaRepository<Category,Integer> {
}
