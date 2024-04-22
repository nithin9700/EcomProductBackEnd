package com.nithin.EcomProductService.service;

import com.nithin.EcomProductService.dto.FakeStoreCartResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;


public interface CartService {
    List<FakeStoreCartResponseDTO> getUserCart(int id);
}
