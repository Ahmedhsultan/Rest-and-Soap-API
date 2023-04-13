package com.example.demo.webservices.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class CustomerDTOResp {
    private Integer id;
    private StoreDTOResp store;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDTOResp address;
    private Boolean active;
    private Instant createDate;
    private Instant lastUpdate;
}
