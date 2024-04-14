package com.nithin.EcomProductService.service;



import com.nithin.EcomProductService.client.FakeStoreClient;
import com.nithin.EcomProductService.dto.FakeStoreProductResponseDTO;
import com.nithin.EcomProductService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreProductClient;

    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreProductClient.getAllProducts();
        return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO  getProduct(int productId) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreProductClient.getProductById(productId);
        return fakeStoreProductResponseDTO;
    }

    @Override
    public FakeStoreProductResponseDTO createProduct(Product product) {
        return null;
    }

    @Override
    public FakeStoreProductResponseDTO updateProduct(Product product, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }


}