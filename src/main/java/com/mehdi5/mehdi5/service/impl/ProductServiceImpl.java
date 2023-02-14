package com.mehdi5.mehdi5.service.impl;


import com.mehdi5.mehdi5.model.Product;
import com.mehdi5.mehdi5.repositrory.ProductRepository;
import com.mehdi5.mehdi5.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;





    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);

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
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


    /*TEST*/

    @Override
    public List<Product> filterHighPrice() {
        return productRepository.filterHighPrice();
    }

    @Override
    public List<Product> filterLowPrice() {
        return productRepository.filterLowPrice();
    }

    @Override
    public List<Product> listViewProducts() {
        return productRepository.listViewProducts();
    }


    @Override
    public List<Product> searchProducts(String keyword) {
        List<Product> productList = productRepository.searchProductsList(keyword);
        List<Product> products = productList;

        return products;
    }





}
