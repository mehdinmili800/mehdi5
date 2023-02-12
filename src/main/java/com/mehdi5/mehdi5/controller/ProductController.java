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
    public String saveProduct(@ModelAttribute("product") ProductDto productDto,
                              @RequestParam("imageProduct")MultipartFile imageProduct) {
        productService.saveProduct(productDto ,imageProduct);
        return "redirect:/products";
    }


    @GetMapping("/students/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit_product";
    }


    @PostMapping("/products/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Product student,
                                Model model) {

        // get student from database by id
        Product existingProduct = productService.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setName(student.getName());
        existingProduct.setDescription(student.getDescription());
        existingProduct.setCostPrice(student.getCostPrice());
        existingProduct.setSalePrice(student.getSalePrice());

        // save updated student object
        productService.updateProduct(existingProduct);
        return "redirect:/products";
    }


    @GetMapping("/products/{id}")
    public String deleteStudent(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }










}
