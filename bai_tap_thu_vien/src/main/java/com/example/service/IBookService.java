package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    void save(Book book);

    void deleteById(Integer id);

    Book findById(Integer id);

    Page<Book> findByName(String keyword, Pageable pageable);

    Page<Book> findAllSaveNote(Pageable pageable);

}
