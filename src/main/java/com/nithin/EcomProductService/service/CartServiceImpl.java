package com.nithin.EcomProductService.service;


import com.nithin.EcomProductService.client.FakeStoreClient;
import com.nithin.EcomProductService.dto.FakeStoreDTO.FakeStoreCartResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreCartResponseDTO> getUserCart(int id) {
        List<FakeStoreCartResponseDTO> fakeStoreCartResponseDTOS =fakeStoreClient.getUserCart(id);

        return fakeStoreCartResponseDTOS;
    }
}
