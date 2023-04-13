package com.example.demo.webserviceies.rest.DTOs.resources;

import lombok.Data;
import java.time.Instant;

@Data
public class StoreDTOResp {
    private Short id;
    private StaffDTOResp managerStaff;
    private AddressDTOResp address;
    private Instant lastUpdate;
}
