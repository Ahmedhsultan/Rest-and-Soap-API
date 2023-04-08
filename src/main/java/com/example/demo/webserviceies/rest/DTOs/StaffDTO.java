package com.example.demo.webserviceies.rest.DTOs;

import lombok.Data;

@Data
public class StaffDTO {
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
