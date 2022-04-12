package com.example.service.impl;

import com.example.model.BorrowedCard;
import com.example.repository.IBorrowedCardRepository;
import com.example.service.IBorrowedCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowedCardService implements IBorrowedCardService {

    @Autowired
    private IBorrowedCardRepository iBorrowedCardRepository;


    @Override
    public void save(BorrowedCard borrowedCard) {
        iBorrowedCardRepository.save(borrowedCard);
    }

    @Override
    public void deleteById(Integer id) {
        iBorrowedCardRepository.deleteById(id);

    }

    @Override
    public void findById(Integer id) {
        iBorrowedCardRepository.findById(id);
    }

    @Override
    public Page<BorrowedCard> findAllBorrowedCard(Pageable pageable) {
        return iBorrowedCardRepository.findAllByOrderById(pageable);
    }
}
