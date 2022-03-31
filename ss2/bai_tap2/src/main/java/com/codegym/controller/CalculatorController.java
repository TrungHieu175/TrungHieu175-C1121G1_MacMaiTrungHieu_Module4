package com.codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class CalculatorController {
    @GetMapping("")
    public String goCalculator(){
        return "calculator";
    }
    @RequestMapping("/calculator")
    public String calculator(@RequestParam Double number1, @RequestParam Double number2, @RequestParam String dau, Model model){
        Double total = 0.0;
        switch (dau){
            case "Addition(+)" :
                total = number1 + number2;
                break;
            case "Subtraction(-)" :
                total = number1 - number2;
                break;
            case "Mutiplication(*)" :
                total = number1 * number2;
                break;
            case "Division(/)" :
                total = number1 / number2;
                break;
        }
        model.addAttribute("total",total);
        return "calculator";
    }
}
