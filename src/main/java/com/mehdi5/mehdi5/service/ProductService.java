package com.mehdi5.mehdi5.service;


import com.mehdi5.mehdi5.dto.ProductDto;
import com.mehdi5.mehdi5.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product saveProduct(Product Product);

    Product getProductById(Long id);

    Product updateProduct(Product Product);


    void deleteById(Long id);
}
