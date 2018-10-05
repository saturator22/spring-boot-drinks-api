package com.codecool.springbootdrinks.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Resource Not Found")
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(Long id) {
        super("Resource not found with id={" + id + "}");
    }

    public ResourceNotFoundException() {
        super("No resources at database.");
    }

}
