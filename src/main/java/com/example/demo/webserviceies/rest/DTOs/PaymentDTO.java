package com.example.demo.webserviceies.rest.DTOs;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDTO {
    private String customerFirstName;
    private String staffFirstName;
    private Integer rentalId;
    private BigDecimal amount;
}
