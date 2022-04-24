package com.example.controller;

import com.example.model.contract.Contract;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @Autowired
    private IContractService iContractService;

    @GetMapping({"", "index"})
    public String goList(Model model, @PageableDefault(value = 5, sort = "customerId", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam Optional<String> keyword) {
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

    @GetMapping( "customerService")
    public String goListCusService(Model model, @PageableDefault(value = 5, sort = "customerId", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Contract> contractPage;
        if (keyword.isPresent()) {
            contractPage = iContractService.findAllPaging(keywordValue, pageable);
        } else {
            contractPage = iContractService.findAllContract(pageable);
        }
        model.addAttribute("list", contractPage);

        model.addAttribute("keywordValue", keywordValue);
        return "listCustomerService";
    }


    @GetMapping("addCus")
    public String add(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", new Customer());
        return "createCus";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Customer customerId = iCustomerService.findById(id);
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerId", customerId);
        return "editCus";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        iCustomerService.save(customer);
        return "redirect:/index";
    }

    @GetMapping("/remove")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id) {
        iCustomerService.deleteById(id);
        return "redirect:/index";
    }
}
