package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class FilmCategoryDTOResp {
    private FilmDTOResp film;
    private CategoryDTOResp category;
    private Instant lastUpdate;

}
