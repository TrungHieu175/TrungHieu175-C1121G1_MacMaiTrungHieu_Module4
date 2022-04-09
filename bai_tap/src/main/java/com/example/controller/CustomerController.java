package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.SaveNoteDto;
import com.example.model.Customer;
import com.example.model.SaveNote;
import com.example.service.ICustomerService;
import com.example.service.impl.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("listCustomer")
    public String goView(Model model) {

        List<Customer> customerList = iCustomerService.findAll();

        model.addAttribute("customerList", customerList);

        return "listCustomer";
    }

    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "addCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Validated @ModelAttribute("customer") CustomerDto customerDto, BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "addCustomer";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.save(customer);
            return "redirect:/listCustomer";
        }
    }
        @GetMapping("editCustomer/{id}")
        public String editCustomer (@PathVariable Integer id, Model model){
            Customer customer = iCustomerService.findById(id);
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer,customerDto);
            model.addAttribute("customer", customerDto);
            return "editCustomer";
        }

        @GetMapping("/deleteCustomer/{id}")
        public String deleteCustomer (@PathVariable Integer id, Model model){
            iCustomerService.deleteById(id);
            return "redirect:/listCustomer";
        }
    }
