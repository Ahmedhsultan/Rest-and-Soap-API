package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;

@Data
public class FilmActorDTOReq {
    private Integer actorId;
    private Integer filmId;
}
