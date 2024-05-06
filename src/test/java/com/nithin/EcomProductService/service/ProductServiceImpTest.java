package com.nithin.EcomProductService.service;


import com.nithin.EcomProductService.dto.ProductRequestDTO;
import com.nithin.EcomProductService.dto.ProductResponseDTO;
import com.nithin.EcomProductService.entity.Category;
import com.nithin.EcomProductService.entity.Product;
import com.nithin.EcomProductService.exception.CategoryNotFoundException;
import com.nithin.EcomProductService.exception.ProductNotFoundException;
import com.nithin.EcomProductService.mapper.ProductEntityDTOMapper;
import com.nithin.EcomProductService.repositories.CategoryRepository;
import com.nithin.EcomProductService.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceImpTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this); // not required nowadays. It initialises and adds all the required mocks
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
        productServiceImpl.getProduct(id);

        assertEquals(productRequestDTO.getProductName(), product.get().getProductName());
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
        List<ProductResponseDTO> actualProductResponseDTOS = productServiceImpl.getAllProducts();
        //ASSERT
        assertEquals(expectedProductResponseDTOS.size(), actualProductResponseDTOS.size());

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

    @Test
    public void createProductCategoryNotFound() {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductCategory("Electronics");

        when(categoryRepository.findByName("Electronics")).thenReturn(null);

        Assertions.assertThrows(CategoryNotFoundException.class, () -> {
            productServiceImpl.createProduct(productRequestDTO);
        });
    }
    @Test
    public void getProductException(){
        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            productServiceImpl.getProduct(UUID.randomUUID());
        });
    }
    @Test
    public void createProduct() {
        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setProductName("Product Name");
        productRequestDTO.setProductDescription("Product Description");
        productRequestDTO.setProductImageURL("Product Image URL");
        productRequestDTO.setProductPrice(1000);
        productRequestDTO.setQuantity(100);
        productRequestDTO.setProductCategory("Electronics");

        Category category = new Category();
        category.setName(productRequestDTO.getProductCategory());
        Product product = ProductEntityDTOMapper.productResponseDTOToProduct(productRequestDTO);
        product.setProductCategory(category);

        when(categoryRepository.findByName(productRequestDTO.getProductCategory())).thenReturn(category);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductResponseDTO result = productServiceImpl.createProduct(productRequestDTO);

        assertEquals(result.getProductName(), productRequestDTO.getProductName());
        assertEquals(result.getProductDescription(), productRequestDTO.getProductDescription());
        assertEquals(result.getProductImageURL(), productRequestDTO.getProductImageURL());
        assertEquals(result.getProductPrice(), productRequestDTO.getProductPrice());
        assertEquals(result.getQuantity(), productRequestDTO.getQuantity());
        assertEquals(result.getProductCategory(), productRequestDTO.getProductCategory());

    }


}
