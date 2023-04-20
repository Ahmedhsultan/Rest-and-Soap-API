package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;

@Data
public class RentalDTOReq {
    private Integer inventoryId;
    private Integer customerId;
    private String returnDateInstance;
    private Integer staffId;
}
