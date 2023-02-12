package com.mehdi5.mehdi5.controller;


import com.mehdi5.mehdi5.dto.ProductDto;
import com.mehdi5.mehdi5.model.Product;
import com.mehdi5.mehdi5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService studentService) {
        super();
        this.productService = studentService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }


    @GetMapping("/products/new")
    public String createProductForm(Model model) {

        // create student object to hold student form data
        Product product = new Product();
        model.addAttribute("product", product);
        return "create_product";

    }


    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }











}
