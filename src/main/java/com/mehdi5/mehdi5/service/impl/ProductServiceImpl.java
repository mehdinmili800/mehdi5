package com.mehdi5.mehdi5.service.impl;


import com.mehdi5.mehdi5.dto.ProductDto;
import com.mehdi5.mehdi5.model.Product;
import com.mehdi5.mehdi5.repositrory.ProductRepository;
import com.mehdi5.mehdi5.service.ProductService;
import com.mehdi5.mehdi5.utils.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    private ImageUpload imageUpload;

    public ProductServiceImpl(ProductRepository studentRepository) {
        super();
        this.productRepository = studentRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(ProductDto productDto, MultipartFile imageProduct) {

        try {
        Product product = new Product();
        if(imageProduct == null){
            product.setImage(null);
        }else{
            if(imageUpload.uploadImage(imageProduct)){
                System.out.println("Upload successfully");
            }
            product.setImage(Base64.getEncoder().encodeToString(imageProduct.getBytes()));
        }
        return productRepository.save(product);
    }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);

    }
}
