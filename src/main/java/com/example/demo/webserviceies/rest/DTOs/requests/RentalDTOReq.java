package com.example.demo.webserviceies.rest.DTOs.requests;

import lombok.Data;

@Data
public class RentalDTOReq {
    private Integer inventoryId;
    private String customerFirstName;
    private String returnDateInstance;
    private String staffFirstName;
}
