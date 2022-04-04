package com.repository.impl;

import com.model.Declaration;
import com.repository.IDeclarationRepository;
import com.service.IDeclarationService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeclarationReposiory implements IDeclarationRepository {

    private static List<String> gender = new ArrayList<>();

    private static List<String> nationality = new ArrayList<>();

    private static List<Declaration> declarationList = new ArrayList<>();

    static {
        nationality.add("Việt Nam");
        nationality.add("Lào");

        gender.add("Nam");
        gender.add("Nữ");
    }

    @Override
    public List<String> getAllGender() {
        return gender;
    }

    @Override
    public List<String> getAllNationality() {
        return nationality;
    }

    @Override
    public void save(Declaration declaration) {
        declarationList.add(declaration);
    }
}
