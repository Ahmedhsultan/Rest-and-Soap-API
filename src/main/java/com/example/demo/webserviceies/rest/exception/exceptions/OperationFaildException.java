package com.example.demo.webserviceies.rest.exception.exceptions;

import jakarta.persistence.PersistenceException;

public class OperationFaildException extends PersistenceException {
    public OperationFaildException(String msg){
        super(msg);
    }
}
