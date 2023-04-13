package com.example.demo.webserviceies.rest.DTOs.requests;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDTOReq {
    private String customerFirstName;
    private String staffFirstName;
    private Integer rentalId;
    private BigDecimal amount;
}
