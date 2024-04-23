package com.nithin.EcomProductService.repositories;

import com.nithin.EcomProductService.entity.Category;
import com.nithin.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByProductName(String name);
    //List<Product> findProductBetweenMinAndMax(int min, int max);
    List<Product> findAllProductsByProductCategory(Category category);
    List<Product> findByProductPriceBetween(double min, double max);

}
