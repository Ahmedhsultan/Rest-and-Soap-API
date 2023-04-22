package com.example.demo.webservices.rest.DTOs.resources;

import lombok.Data;

import java.time.Instant;

@Data
public class ActorDTOResp {
    private Integer id;
    private String firstName;
    private String lastName;
    private Instant lastUpdate;
}
