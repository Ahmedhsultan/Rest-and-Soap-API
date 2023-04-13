package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class CityDTOResp {
    private Integer id;
    private String city;
    private CountryDTOResp country;
    private Instant lastUpdate;
}
