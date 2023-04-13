package com.example.demo.webservices.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class CityDTOResp {
    private Integer id;
    private String city;
    private CountryDTOResp country;
    private Instant lastUpdate;
}
