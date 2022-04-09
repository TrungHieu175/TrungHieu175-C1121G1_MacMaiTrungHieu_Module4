package com.example.service;

import com.example.model.SaveNote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISaveNoteService {

    void save(SaveNote saveNote);

    void deleteById(Integer id);

    SaveNote findById(Integer id);

    Page<SaveNote> findByName(String keyword, Pageable pageable);

    Page<SaveNote> findAllSaveNote(Pageable pageable);

    List<SaveNote> findAll();
}
