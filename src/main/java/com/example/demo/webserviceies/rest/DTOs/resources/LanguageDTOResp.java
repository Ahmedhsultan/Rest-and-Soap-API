package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class LanguageDTOResp {
    private Short id;
    private String name;
    private Instant lastUpdate;
}
