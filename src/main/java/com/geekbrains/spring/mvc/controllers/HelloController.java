package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/box_page")
    public String showProductPage(Model model) {
        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);
        return "hello";
    }

    @GetMapping("/hello_user")
    @ResponseBody
    public String sayHello(@RequestParam(name = "name", defaultValue = "Unknown") String username, @RequestParam(defaultValue = "Unknown") String surname) {
        return String.format("Hello, %s %s!!!", username, surname);
    }

    // http://localhost:8189/app/docs/100/info
    @GetMapping("/docs/{doc_id}/info")
    @ResponseBody
    public String showDocInfo(@PathVariable(name = "doc_id") Long id) {
        return "Document #" + id;
    }

    @PostMapping("/add_box")
    public String addNewProduct(@RequestParam String name, @RequestParam int cost) {
        Product product = new Product(1L, name, cost);
        productService.save(product);
        return "redirect:/box_page";
    }

    @GetMapping("/delete_box/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/box_page";
    }
}
