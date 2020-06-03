package com.example.SpringException.ExceptionsDemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
    @ExceptionHandler(value = ProductException.class)
    public ResponseEntity exception(ProductException productException){
        return new ResponseEntity("Product Not Found", HttpStatus.NOT_FOUND);
    }
}
