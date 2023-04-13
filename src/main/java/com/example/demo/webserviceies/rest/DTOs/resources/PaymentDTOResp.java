package com.example.demo.webserviceies.rest.DTOs.resources;

import com.example.demo.repository.entities.Rental;
import lombok.Data;
import java.math.BigDecimal;
import java.time.Instant;

@Data
public class PaymentDTOResp {
    private Integer id;
    private CustomerDTOResp customer;
    private StaffDTOResp staff;
    private Rental rental;
    private BigDecimal amount;
    private Instant paymentDate;
    private Instant lastUpdate;
}
