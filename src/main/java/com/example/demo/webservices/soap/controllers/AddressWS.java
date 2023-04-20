package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Address;
import com.example.demo.servicies.AddressService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.AddressDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.AddressDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class AddressWS {
    private AddressService AddressService;
    public AddressWS(){
        this.AddressService = new AddressService();
    }
    public Address post(AddressDTOReq AddressDTOReq) throws SoapException {
        Address address = AddressService.post(AddressDTOReq);

        return address;
    }
    public List<AddressDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var addressDTOResp = AddressService.get(queryPage);

        return addressDTOResp;
    }
    public List<AddressDTOResp> getAll() {
        var addressDTOResps = AddressService.getAll();

        return addressDTOResps;
    }
    public long getCount() {
        var count = AddressService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        AddressService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(AddressDTOResp dtoResp) {
        AddressService.delete(dtoResp);

        return true;
    }
    public boolean put(AddressDTOResp dtoResp) {
        AddressService.put(dtoResp);

        return true;
    }
}