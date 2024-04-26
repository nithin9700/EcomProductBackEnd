package com.nithin.EcomProductService.controller;

import com.nithin.EcomProductService.dto.FakeStoreDTO.FakeStoreCartResponseDTO;
import com.nithin.EcomProductService.exception.CartNotFoundException;
import com.nithin.EcomProductService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> cartResponse = cartService.getUserCart(userId);
        if(cartResponse == null || cartResponse.isEmpty()){
            throw new CartNotFoundException("No cart found with id: " + userId);
        }
        return ResponseEntity.ok(cartResponse);
    }
}
/*
@Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDTO> cartResponse = fakeStoreClient.getCartByUserId(userId);
        if(cartResponse == null){
            throw new CartNotFoundException("Cart not found for userID " + userId);
        }
        return ResponseEntity.ok(cartResponse);
    }
 */
