package com.example.cimeri.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException() {
        super("Невалидна e-mail адреса.");
    }
}
