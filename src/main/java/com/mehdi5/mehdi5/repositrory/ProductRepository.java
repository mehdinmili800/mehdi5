package com.mehdi5.mehdi5.repositrory;

import com.mehdi5.mehdi5.dto.ProductDto;
import com.mehdi5.mehdi5.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false" +
            " order by p.costPrice desc")
    List<Product> filterHighPrice();

    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false order by p.costPrice ")
    List<Product> filterLowPrice();

    @Query(value = "select * from products p where p.is_deleted = false and p.is_activated = true order by rand() asc limit 4 ", nativeQuery = true)
    List<Product> listViewProducts();

    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false")
    List<Product> getAllProducts();

    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    List<Product> searchProductsList(String keyword);









}
