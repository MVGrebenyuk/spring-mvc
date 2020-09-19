package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boxes")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService boxService) {
        this.productService = boxService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_boxes";
    }

    @PostMapping("/add")
//    public String addNewBox(@RequestParam Long id, @RequestParam String color, @RequestParam int size) {
    public String addNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/boxes/all";
    }

    @PostMapping("/json/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewJsonProduct(@RequestBody Product product) {
        productService.save(product);
    }


}
