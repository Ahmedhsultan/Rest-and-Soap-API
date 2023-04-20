package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;

@Data
public class StaffDTOReq {
    private String firstName;
    private String lastName;
    private Integer address;
    private byte[] picture;
    private String email;
    private Integer store;
    private Boolean active;
    private String username;
    private String password;
}
