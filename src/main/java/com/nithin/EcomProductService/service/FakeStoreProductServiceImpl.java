package com.nithin.EcomProductService.service;



import com.nithin.EcomProductService.client.FakeStoreClient;
import com.nithin.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakestoreProductService")
public class FakeStoreProductServiceImpl {

    @Autowired
    private FakeStoreClient fakeStoreProductClient;


    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreProductClient.getAllProducts();
        return fakeStoreProducts;
    }

    public FakeStoreProductResponseDTO  getProduct(int productId) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreProductClient.getProductById(productId);
        return fakeStoreProductResponseDTO;
    }


    public Product createProduct(Product product) {
        return null;
    }


    public Product updateProduct(Product product, int productId) {
        return null;
    }


    public boolean deleteProduct(int productId) {
        return false;
    }


}