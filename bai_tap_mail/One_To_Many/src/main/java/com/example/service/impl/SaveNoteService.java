package com.example.service.impl;

import com.example.model.SaveNote;
import com.example.repository.ISaveNoteRepository;
import com.example.service.ISaveNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveNoteService implements ISaveNoteService {

    @Autowired
    private ISaveNoteRepository iSaveNoteRepository;

    @Override
    public void save(SaveNote saveNote) {
        iSaveNoteRepository.save(saveNote);
    }

    @Override
    public void deleteById(Integer id) {
        iSaveNoteRepository.deleteById(id);
    }

    @Override
    public SaveNote findById(Integer id) {
        return iSaveNoteRepository.findById(id).orElse(null);
    }

    @Override
    public Page<SaveNote> findByName(String keyword, Pageable pageable) {
        return iSaveNoteRepository.findAllByCustomerNameContaining(keyword,pageable);
    }

    @Override
    public Page<SaveNote> findAllSaveNote(Pageable pageable) {
        return iSaveNoteRepository.findAllByOrderByTimeStar(pageable);
    }

    @Override
    public List<SaveNote> findAll() {
        return iSaveNoteRepository.findAll();
    }
}
