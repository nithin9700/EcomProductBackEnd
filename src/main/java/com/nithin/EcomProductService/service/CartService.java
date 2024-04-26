package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.FakeStoreDTO.FakeStoreCartResponseDTO;

import java.util.List;


public interface CartService {
    List<FakeStoreCartResponseDTO> getUserCart(int id);
}
