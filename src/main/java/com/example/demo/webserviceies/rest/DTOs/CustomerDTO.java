package com.example.demo.webserviceies.rest.DTOs;

import lombok.Data;

@Data
public class CustomerDTO {
    private Integer store_ID;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
