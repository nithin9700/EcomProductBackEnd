package com.nithin.EcomProductService.exception;


import com.nithin.EcomProductService.controller.CartController;
import com.nithin.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleCartNotFoundException(CartNotFoundException e) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(404, e.getMessage());
        return new ResponseEntity(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
