package com.example.service.impl;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        iBookRepository.deleteById(id);
    }

    @Override
    public Book findById(Integer id) {

        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Book> findByName(String keyword, Pageable pageable) {
        return iBookRepository.findAllByNameBookContaining(keyword,pageable);
    }

    @Override
    public Page<Book> findAllBook(Pageable pageable) {
        return iBookRepository.findAllByOrderById(pageable);
    }
}
