package com.example.demo.webservices.rest.DTOs.requests;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDTOReq {
    private Integer customerId;
    private Integer staffId;
    private Integer rentalId;
    private BigDecimal amount;
}
