package com.nithin.EcomProductService.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDTO {
    private String message;
    private int code;

    public ExceptionResponseDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

