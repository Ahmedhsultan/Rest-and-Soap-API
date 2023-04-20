package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Country;
import com.example.demo.servicies.CountryService;
import com.example.demo.webservices.rest.DTOs.requests.CountryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CountryDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import java.util.List;

public class CountryWS {
    private CountryService countryService;
    public CountryWS(){
        this.countryService = new CountryService();
    }
    public Country post(CountryDTOReq countryDTOReq) throws SoapException {
        Country country = countryService.post(countryDTOReq);

        return country;
    }
    public List<CountryDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        var countryDTOResps = countryService.get(columnName, value, pageNumber, count);

        return countryDTOResps;
    }
    public List<CountryDTOResp> getAll() {
        var countryDTOResps = countryService.getAll();

        return countryDTOResps;
    }
    public long getCount() {
        var count = countryService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        countryService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(CountryDTOResp dtoResp) {
        countryService.delete(dtoResp);

        return true;
    }
    public boolean put(CountryDTOResp dtoResp) {
        countryService.put(dtoResp);

        return true;
    }
}
