package com.example.repository;

import com.example.model.SaveNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaveNoteRepository extends JpaRepository<SaveNote,Integer> {

    Page<SaveNote> findAllByCustomerNameContaining(String name, Pageable pageable);

    Page<SaveNote> findAllByOrderByTimeStar(Pageable pageable);
}
