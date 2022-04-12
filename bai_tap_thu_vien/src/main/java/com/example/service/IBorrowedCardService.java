package com.example.service;

import com.example.model.Book;
import com.example.model.BorrowedCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowedCardService {

    void save (BorrowedCard borrowedCard);

    void deleteById(Integer id);

    void findById(Integer id);

    Page<BorrowedCard> findAllBorrowedCard(Pageable pageable);
}
