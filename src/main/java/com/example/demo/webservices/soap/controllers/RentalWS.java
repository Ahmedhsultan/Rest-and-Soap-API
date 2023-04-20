package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Rental;
import com.example.demo.servicies.RentalService;
import com.example.demo.webservices.rest.DTOs.requests.RentalDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.RentalDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class RentalWS {
    private RentalService rentalService;
    public RentalWS(){
        this.rentalService = new RentalService();
    }
    public Rental post(RentalDTOReq rentalDTOReq) throws SoapException {
        Rental rental = rentalService.post(rentalDTOReq);

        return rental;
    }
    public List<RentalDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        var rentalDTOResps = rentalService.get(columnName, value, pageNumber, count);

        return rentalDTOResps;
    }
    public List<RentalDTOResp> getAll() {
        var rentalDTOResps = rentalService.getAll();

        return rentalDTOResps;
    }
    public long getCount() {
        var count = rentalService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        rentalService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(RentalDTOResp dtoResp) {
        rentalService.delete(dtoResp);

        return true;
    }
    public boolean put(RentalDTOResp dtoResp) {
        rentalService.put(dtoResp);

        return true;
    }
}
