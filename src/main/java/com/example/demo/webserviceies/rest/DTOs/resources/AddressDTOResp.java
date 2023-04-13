package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class AddressDTOResp {
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private CityDTOResp city;
    private String postalCode;
    private String phone;
    private Instant lastUpdate;
}
