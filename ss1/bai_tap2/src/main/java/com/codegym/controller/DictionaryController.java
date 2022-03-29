package com.codegym.controller;

import com.codegym.model.Dictionary;
import com.codegym.service.IDictionaryService;
import com.codegym.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService = new DictionaryService();
    @GetMapping({"","/search"})
    public String search() {
        return "greeting";
    }
    @PostMapping("/greeting")
    public String meaning(@RequestParam String keyword, Model model) {
        String vietnamese = iDictionaryService.findVietnamese(keyword);
        model.addAttribute("vietnam",vietnamese);
        return "greeting";
    }
}
