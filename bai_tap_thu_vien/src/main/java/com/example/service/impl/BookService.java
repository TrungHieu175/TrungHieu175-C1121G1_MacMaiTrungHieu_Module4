package com.example.service.impl;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Override
    public void save(Book book) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Book findById(Integer id) {
        return null;
    }

    @Override
    public Page<Book> findByName(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Book> findAllSaveNote(Pageable pageable) {
        return null;
    }
}
