package com.example.service.impl;

import com.example.model.Book;
import com.example.model.BorrowedCard;
import com.example.service.IBorrowedCardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BorrowedCardService implements IBorrowedCardService {
    @Override
    public void save(BorrowedCard borrowedCard) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void findById(Integer id) {

    }

    @Override
    public Page<BorrowedCard> findAllBorrowedCard(Pageable pageable) {
        return null;
    }
}
