package com.nithin.EcomProductService.exception;

public class NoProductFoundException extends RuntimeException{
    public NoProductFoundException(String message) {
        super(message);
    }
}
