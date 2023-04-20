package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;

@Data
public class CityDTOReq {
    private String city;
    private Integer countryId;
}
