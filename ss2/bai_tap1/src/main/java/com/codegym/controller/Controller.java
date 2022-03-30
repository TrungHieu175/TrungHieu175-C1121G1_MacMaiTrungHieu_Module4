package com.codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("")
    public String showform() {
        return "list";
    }

    @RequestMapping("/save")
    public String save(@RequestParam( value = "condiment", defaultValue = "condimenothing") String[] condiment, Model model) {
        model.addAttribute("list", condiment);
        return "menu";
    }
}
