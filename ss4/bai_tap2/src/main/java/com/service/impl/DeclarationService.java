package com.service.impl;

import com.model.Declaration;
import com.repository.IDeclarationRepository;
import com.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {

    @Autowired
    IDeclarationRepository iDeclarationRepository;
    @Override
    public List<String> getAllGender() {
        return iDeclarationRepository.getAllGender();
    }

    @Override
    public List<String> getAllNationality() {
        return iDeclarationRepository.getAllNationality();
    }

    @Override
    public void save(Declaration declaration) {
        iDeclarationRepository.save(declaration);
    }
}
