package com.example.demo.webserviceies.rest.DTOs;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class FilmDTO {
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
