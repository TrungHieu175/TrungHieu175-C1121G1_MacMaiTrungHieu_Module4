package com.codegym.service.impl;

import com.codegym.model.Dictionary;
import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    private static List<Dictionary> dictionaries = new ArrayList<>();

    static {
        dictionaries.add(new Dictionary("hello","xin chào"));
        dictionaries.add(new Dictionary("anh hieu","đẹp trai"));
        dictionaries.add(new Dictionary("hieu mm","rất đẹp trai"));
        dictionaries.add(new Dictionary("cat","con mèo"));
        dictionaries.add(new Dictionary("coin","đồng xu"));
        dictionaries.add(new Dictionary("card","thẻ"));
        dictionaries.add(new Dictionary("dog","con chó"));
    }

    @Override
    public List<Dictionary> findAll() {
        return dictionaries;
    }

    @Override
    public String findVietnamese(String keyword) {
        String vietNam = "not found";
        for(Dictionary dictionary : dictionaries){
            if (dictionary.getEnglish().equals(keyword)){
                vietNam = dictionary.getVietnamese();
                break;
            }
        }
        return vietNam;
    }
}
