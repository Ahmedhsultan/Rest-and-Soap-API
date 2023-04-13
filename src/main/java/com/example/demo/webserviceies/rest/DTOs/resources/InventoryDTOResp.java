package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class InventoryDTOResp {
    private Integer id;
    private FilmDTOResp film;
    private StoreDTOResp store;
    private Instant lastUpdate;
}
