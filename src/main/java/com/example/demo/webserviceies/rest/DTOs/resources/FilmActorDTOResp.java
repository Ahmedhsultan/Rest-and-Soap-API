package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class FilmActorDTOResp {
    private ActorDTOResp actor;
    private FilmDTOResp film;
    private Instant lastUpdate;
}
