package com.nithin.EcomProductService.service;


import com.nithin.EcomProductService.dto.ProductRequestDTO;
import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Category;
import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.exception.ProductNotFoundException;
import com.nithin.EcomProductService.mapper.ProductEntityDTOMapper;
import com.nithin.EcomProductService.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

public class ProductServiceImpTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); // not required nowadays. It initialises and adds all the required mocks
    }


    @Test
    public void getProductsException(){
        UUID id = UUID.randomUUID();
        when(productRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ProductNotFoundException.class, () -> productService.getProduct(id));
    }
    @Test
    public void getProduct(){
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Product Name");
        productRequestDTO.setProductPrice(100);
        productRequestDTO.setProductDescription("Product Description");
        productRequestDTO.setQuantity(10);
        productRequestDTO.setProductImageURL("Product Image URL");

        Optional<Product> product = getProduct(productRequestDTO);
        UUID id = UUID.randomUUID();

        when(productRepository.findById(id)).thenReturn(product);
        productService.getProduct(id);

        Assertions.assertEquals(productRequestDTO.getProductName(), product.get().getProductName());
    }

    private Optional<Product> getProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        product.setProductDescription(productRequestDTO.getProductDescription());
        product.setProductImageURL(productRequestDTO.getProductImageURL());
        product.setProductPrice(productRequestDTO.getProductPrice());
        product.setQuantity(productRequestDTO.getQuantity());
        product.setProductImageURL(productRequestDTO.getProductImageURL());
        product.setProductCategory(new Category());
        return Optional.of(product);
    }

    @Test
    public void getAllProductsTest() {
        //AAA
        // ARRANGE
        List<Product> products = products();
        List<ProductResponseDTO> expectedProductResponseDTOS = new ArrayList<>();
        for (Product product : products) {
            expectedProductResponseDTOS.add(ProductEntityDTOMapper.productToProductResponseDTO(product));
        }
        //ACT
        when(productRepository.findAll()).thenReturn(products);
        List<ProductResponseDTO> actualProductResponseDTOS = productService.getAllProducts();
        //ASSERT
        Assertions.assertEquals(expectedProductResponseDTOS.size(), actualProductResponseDTOS.size());

    }
    public List<Product> products() {
        Product product1 = new Product();
        product1.setProductName("Product Name1");
        product1.setProductCategory(new Category());
        Product product2 = new Product();
        product2.setProductName("Product Name2");
        product2.setProductCategory(new Category());
        Product product3 = new Product();
        product3.setProductName("Product Name3");
        product3.setProductCategory(new Category());
        List<Product> products = new ArrayList<>(List.of(product3, product1, product2));
        return products;
    }



}
