package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

//    // DI
//    @Qualifier("sumService")
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"", "/customers"})
    public String goGreeting(Model  model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers",customerList);
        // /WEB-INF/views/greeting.jsp
        return "greeting";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam long id,Model model){

        Customer customer = customerService.findOne(id);

        model.addAttribute("customer",customer);

        return "edit";
    }
}
