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
    private IConverterService iConverterService;


    @GetMapping(value = {"", "/converter"})
    public String goConverter() {
        return "converter";
    }

    @PostMapping(value = {"/converter"})
    public String converter(@RequestParam int usd,
                          Model model) {

        int result = this.iConverterService.converterUsd(usd);
        model.addAttribute("result", result);
        return "converter";
    }
}
