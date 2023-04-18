package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class FilmDTOReq {
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer languageId;//Language
    private Integer originalLanguageId;//Language
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
}
