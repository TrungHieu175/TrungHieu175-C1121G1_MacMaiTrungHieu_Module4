package com.codegym.controller;

import com.codegym.service.IConverteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverteController {
    
    // DI
    @Autowired
    private IConverteService iConverteService;


    @GetMapping(value = {"", "/abc"})
    public String goGreeting() {
        // /WEB-INF/views/greeting.jsp
        return "greeting";
    }

    @PostMapping(value = {"/greeting"})
    public String sum2Num(@RequestParam int a,
                          Model model) {

        int result = this.iConverteService.converteUsd(a);
        model.addAttribute("result", result);
        return "greeting";
    }
}
