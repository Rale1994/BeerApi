package com.beerapi.BeerApi.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class BeerException extends RuntimeException {
    public BeerException(String message) {
        super(message);
    }

//    public ResponseEntity<?> customFieldException(MethodArgumentNotValidException exception) {
//        return new ResponseEntity<>();
//    }
}
