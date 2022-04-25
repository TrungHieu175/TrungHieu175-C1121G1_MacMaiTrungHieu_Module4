package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
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
public class EmployeeController {

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @GetMapping("viewEmployee")
    public String goList(Model model, @PageableDefault(value = 5, sort = "employeeId", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Employee> employeePage;
        if (keyword.isPresent()) {
            employeePage = iEmployeeService.findAllPaging(keywordValue, pageable);
        } else {
            employeePage = iEmployeeService.findAllEmployee(pageable);
        }
        model.addAttribute("list", employeePage);
        model.addAttribute("keywordValue", keywordValue);
        return "viewEmployee";
    }

    @GetMapping("addEm")
    public String add(Model model) {
        List<Position> positionList = iPositionService.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = iDivisionService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employee", new EmployeeDto());
        return "createEm";
    }

    @GetMapping("editEm/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Employee employeeId = iEmployeeService.findById(id);
        List<Position> positionList = iPositionService.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        List<Division> divisionList = iDivisionService.findAll();
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("employeeId", employeeId);
        return "editEm";
    }

    @PostMapping("/saveEm")
    public String save(Employee employee) {
        iEmployeeService.save(employee);
        return "redirect:/viewEmployee";
    }

    @GetMapping("/removeEm")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id){
        iEmployeeService.deleteById(id);
        return "redirect:/viewEmployee";
    }
}
