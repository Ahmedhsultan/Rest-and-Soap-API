package com.example.demo.webservices.soap.exception;

import jakarta.xml.ws.WebFault;

@WebFault
public class SoapException extends Exception{
    private static final long serialVersionUID = 1L;

    public SoapException(String message) {
        super(message);
    }

    public String getFaultInfo() {
        return this.getMessage();
    }
}
