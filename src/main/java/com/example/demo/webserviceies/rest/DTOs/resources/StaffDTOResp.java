package com.example.demo.webserviceies.rest.DTOs.resources;

import com.example.demo.repository.entities.Address;
import lombok.Data;

import java.time.Instant;

@Data
public class StaffDTOResp {
    private Short id;
    private String firstName;
    private String lastName;
    private Address address;
    private byte[] picture;
    private String email;
    private StoreDTOResp store;
    private Boolean active = false;
    private String username;
    private String password;
    private Instant lastUpdate;
}
