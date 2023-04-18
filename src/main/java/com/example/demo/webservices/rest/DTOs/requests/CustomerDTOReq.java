package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;

@Data
public class CustomerDTOReq {
    private Integer storeId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer addressId;
}
