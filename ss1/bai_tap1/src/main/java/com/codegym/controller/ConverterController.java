package com.codegym.controller;

import com.codegym.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @Autowired
    private IConverterService iConverteService;


    @GetMapping(value = {"", "/converter"})
    public String goConverter() {
        return "converter";
    }

    @PostMapping(value = {"/converter"})
    public String converter(@RequestParam int a,
                          Model model) {

        int result = this.iConverteService.converteUsd(a);
        model.addAttribute("result", result);
        return "converter";
    }
}
