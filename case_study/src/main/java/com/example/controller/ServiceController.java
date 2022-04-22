package com.example.controller;

import com.example.model.service.RentType;
import com.example.model.service.Service;
import com.example.model.service.ServiceType;
import com.example.service.service.IRentTypeService;
import com.example.service.service.IServiceService;
import com.example.service.service.IServiceTypeService;
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
public class ServiceController {

    @Autowired
    private IRentTypeService iRentTypeService;

    @Autowired
    private IServiceService iServiceService;

    @Autowired
    private IServiceTypeService iServiceTypeService;

    @GetMapping("viewService")
    public String goList(Model model, @PageableDefault(value = 5, sort = "serviceId", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<Service> servicePage;
        if (keyword.isPresent()) {
            servicePage = iServiceService.findAllPaging(keywordValue, pageable);
        } else {
            servicePage = iServiceService.findAllService(pageable);
        }
        model.addAttribute("list", servicePage);
        model.addAttribute("keywordValue", keywordValue);
        return "viewService";
    }

    @GetMapping("addSer")
    public String add(Model model) {
        List<RentType> rentTypeList = iRentTypeService.findAll();
        List<ServiceType> serviceTypeList = iServiceTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("service", new Service());
        return "createSer";
    }

    @GetMapping("editSer/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Service serviceId = iServiceService.findById(id);
        List<RentType> rentTypeList = iRentTypeService.findAll();
        List<ServiceType> serviceTypeList = iServiceTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("serviceTypeList", serviceTypeList);
        model.addAttribute("serviceId", serviceId);
        return "editSer";
    }

    @PostMapping("/saveSer")
    public String save(Service service) {
        iServiceService.save(service);
        return "redirect:/viewService";
    }

    @GetMapping("/removeSer")
    public String delete(RedirectAttributes redirectAttributes, @RequestParam Integer id){
        iServiceService.deleteById(id);
        return "redirect:/viewService";
    }
}
