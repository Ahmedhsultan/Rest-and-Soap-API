package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class FilmDTOReq {
    private String title;
    private String description;
    private Integer releaseYear;
    private String language;//Language
    private String originalLanguage;//Language
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
}
