package com.example.controller;

import com.example.model.customer.Customer;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping({"", "/index"})
    public String goList(Model model, @PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Customer> customerPage;
        if (keyword.isPresent()) {
            customerPage = iCustomerService.findAllPaging(keywordValue, pageable);
        } else {
            customerPage = iCustomerService.findAllCustomer(pageable);
        }
        model.addAttribute("list", customerPage);
        model.addAttribute("keywordValue", keywordValue);
        return "index";
    }
}
