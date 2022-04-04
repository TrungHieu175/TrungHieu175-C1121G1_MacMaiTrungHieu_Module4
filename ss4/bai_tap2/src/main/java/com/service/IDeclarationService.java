package com.service;

import com.model.Declaration;

import java.util.List;

public interface IDeclarationService {

    List<String> getAllGender();

    List<String> getAllNationality();

    void save (Declaration declaration);
}
