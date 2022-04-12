package com.example.repository;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findAllByNameBookContaining(String keyword, Pageable pageable);

    Page<Book> findAllByOrderById(Pageable pageable);
}
