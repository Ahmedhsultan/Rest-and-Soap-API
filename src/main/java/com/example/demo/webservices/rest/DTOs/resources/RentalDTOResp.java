package com.example.demo.webservices.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class RentalDTOResp {
    private Integer id;
    private Instant rentalDate;
    private InventoryDTOResp inventory;
    private CustomerDTOResp customer;
    private Instant returnDate;
    private StaffDTOResp staff;
    private Instant lastUpdate;
}
