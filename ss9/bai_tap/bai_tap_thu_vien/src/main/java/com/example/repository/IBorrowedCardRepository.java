package com.example.repository;

import com.example.model.BorrowedCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowedCardRepository extends JpaRepository<BorrowedCard,Integer> {
    Page<BorrowedCard> findAllByOrderById(Pageable pageable);
}
