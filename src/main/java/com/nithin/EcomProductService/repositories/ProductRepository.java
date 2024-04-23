package com.nithin.EcomProductService.repositories;

import com.nithin.EcomProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findByName(String name);
    List<Product> findProductBetweenMinAndMax(int min, int max);

}
