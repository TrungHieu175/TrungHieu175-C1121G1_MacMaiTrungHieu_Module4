package com.example.controller;

import com.example.dto.ContractDto;
import com.example.dto.CustomerDto;
import com.example.model.contract.Contract;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.service.Service;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ContractController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IServiceService iServiceService;

    @Autowired
    private IContractService iContractService;

    @GetMapping("viewContract")
    public String goList(Model model, @PageableDefault(value = 5, sort = "contractDetailId", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Contract> contractPage;
        if (keyword.isPresent()) {
            contractPage = iContractService.findAllPaging(keywordValue, pageable);
        } else {
            contractPage = iContractService.findAllContract(pageable);
        }
        model.addAttribute("list", contractPage);
        model.addAttribute("keywordValue", keywordValue);
        return "contract/viewContract";
    }

    @GetMapping("addCon")
    public String add(Model model) {
        List<Employee> employeeList = iEmployeeService.findAll();
        List<Customer> customerList = iCustomerService.findAll();
        List<Service> serviceList = iServiceService.findAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("contract", new ContractDto());
        return "contract/createCon";
    }

    @GetMapping("editCon/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Contract contractId = iContractService.findById(id);
        List<Employee> employeeList = iEmployeeService.findAll();
        List<Customer> customerList = iCustomerService.findAll();
        List<Service> serviceList = iServiceService.findAll();
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contractId,contractDto);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("contractId", contractDto);
        return "contract/editCon";
    }

    @PostMapping("/saveCon")
    public String save(@Validated @ModelAttribute("contract") ContractDto contractDto , BindingResult bindingResult, Model model , Contract contract) {
        contractDto.validate(contractDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerList",iCustomerService.findAll());
            return "createCon";
        }else {
            BeanUtils.copyProperties(contractDto,contract);
            iContractService.save(contract);
            return "redirect:/viewContract";
        }
    }

    @GetMapping("/removeCon")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id){
        iEmployeeService.deleteById(id);
        return "redirect:/viewContract";
    }
}
