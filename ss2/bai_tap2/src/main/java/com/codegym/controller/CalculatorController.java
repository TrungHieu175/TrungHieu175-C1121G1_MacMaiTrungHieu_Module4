package com.codegym.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class CalculatorController {

    @GetMapping("")
    public String goCalculator(Model model) {
        Double total = 0.0;
        model.addAttribute("total", total);
        return "calculator";
    }

    @RequestMapping("/calculator")
    public String calculator(@RequestParam Double number1, @RequestParam Double number2, @RequestParam String operator, Model model) {
        Double total = 0.0;
        switch (operator) {
            case "+":
                total = number1 + number2;
                break;
            case "-":
                total = number1 - number2;
                break;
            case "*":
                total = number1 * number2;
                break;
            case "/":
                total = number1 / number2;
                break;
            default:
                total = 0.0;
                break;
        }
        model.addAttribute("total", total);
        return "calculator";
    }
}
