package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @GetMapping({"","product"})
    public String index(Model model) {

        List<Product> productList = iProductService.findAll();
        model.addAttribute("product", productList);
        return "/index";
    }

    @PostMapping("/save")
    public String save(Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        iProductService.update(product.getId());
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }
}