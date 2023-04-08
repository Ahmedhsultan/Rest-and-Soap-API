package com.example.demo.webserviceies.rest.DTOs;

import lombok.Data;

@Data
public class RentalDTO {
    private Integer inventoryId;
    private String customerFirstName;
    private String returnDateInstance;
    private String staffFirstName;
}
