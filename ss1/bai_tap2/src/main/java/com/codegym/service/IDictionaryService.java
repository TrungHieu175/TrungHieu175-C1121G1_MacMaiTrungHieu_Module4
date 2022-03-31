package com.codegym.service;

import com.codegym.model.Dictionary;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IDictionaryService {

    List<Dictionary>findAll();

    String findVietnamese(String keyword);
}
