package com.example.demo.webservices.rest.DTOs.resources;

import lombok.Data;

import java.time.Instant;

@Data
public class CategoryDTOResp {
    private Short id;
    private String name;
    private Instant lastUpdate;
}
