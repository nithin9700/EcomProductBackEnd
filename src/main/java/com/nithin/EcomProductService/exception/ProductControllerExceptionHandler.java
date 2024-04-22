package com.nithin.EcomProductService.exception;


import com.nithin.EcomProductService.controller.ProductController;
import com.nithin.EcomProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

    @ExceptionHandler({ProductNotFoundException.class, NoProductFoundException.class})
    public ResponseEntity handleException(RuntimeException e) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(404, e.getMessage());
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleException(InvalidInputException e) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(400, e.getMessage());
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
