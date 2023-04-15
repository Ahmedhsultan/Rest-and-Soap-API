package com.example.demo.webservices.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class FilmActorDTOResp {
    private FilmActorIdDTOResp id;
    private ActorDTOResp actor;
    private FilmDTOResp film;
    private Instant lastUpdate;
}
