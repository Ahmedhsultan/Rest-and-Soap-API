package com.example.demo.webserviceies.rest.DTOs.requests;


import lombok.Data;

@Data
public class AddressDTOReq {
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private String city;
}
