package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class CountryDTOResp {
    private Integer id;
    private String country;
    private Instant lastUpdate;
}
