package com.example.demo.webservices.rest.DTOs.resources;

import com.example.demo.repository.entities.Language;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class FilmDTOResp {
    private Integer id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Language language;
    private Language originalLanguage;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Instant lastUpdate;
}
