package com.repository;

import com.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {

    List<String> getAllGender();

    List<String> getAllNationality();

    void save (Declaration declaration);
}
