package com.example.demo.webservices.rest.exception.exceptions;

import jakarta.persistence.PersistenceException;

public class FileNotFoundException extends PersistenceException {
    public FileNotFoundException(String msg){
        super(msg);
    }
}
