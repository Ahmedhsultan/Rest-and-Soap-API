package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class ActorDTOResp {
    private Integer id;
    private String firstName;
    private String lastName;
    private Instant lastUpdate;
}
