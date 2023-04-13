package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;

@Data
public class StaffDTOReq {
    private String firstName;
    private String lastName;
    private String address;
    private byte[] picture;
    private String email;
    private Integer storeId;
    private Boolean active;
    private String username;
    private String password;
}
