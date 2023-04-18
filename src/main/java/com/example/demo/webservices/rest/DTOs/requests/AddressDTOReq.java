package com.example.demo.webservices.rest.DTOs.requests;


import lombok.Data;

@Data
public class AddressDTOReq {
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String phone;
    private Integer cityId;
    private byte[] location;
}
