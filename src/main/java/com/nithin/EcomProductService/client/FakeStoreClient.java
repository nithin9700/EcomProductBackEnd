package com.nithin.EcomProductService.client;


import com.nithin.EcomProductService.dto.FakeStoreDTO.FakeStoreCartResponseDTO;
import com.nithin.EcomProductService.dto.FakeStoreDTO.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}") // this annotation will, fetch the value from app properties and inject that value to this variable
    private String fakeStoreAPIBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductPath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String cartURL;

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int productId){
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseUrl.concat(fakeStoreAPIProductPath).concat("/" + productId);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponseList =
                restTemplate.getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO.class);
        return productResponseList.getBody();
    }


    public List<FakeStoreCartResponseDTO> getUserCart(int userId) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        String url = fakeStoreAPIBaseUrl.concat( cartURL).concat(String.valueOf(userId));

        ResponseEntity<FakeStoreCartResponseDTO[]> fakeStoreCartResponseDTOS =
                restTemplate.getForEntity(url, FakeStoreCartResponseDTO[].class);
        return List.of(fakeStoreCartResponseDTOS.getBody());

    }
}
