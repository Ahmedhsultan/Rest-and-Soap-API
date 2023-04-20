package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.City;
import com.example.demo.servicies.CityService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.CityDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CityDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class CityWS {
    private CityService cityService;
    public CityWS(){
        this.cityService = new CityService();
    }
    public City post(CityDTOReq cityDTOReq) throws SoapException {
        City city = cityService.post(cityDTOReq);

        return city;
    }
    public List<CityDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var cityDTOResps = cityService.get(queryPage);

        return cityDTOResps;
    }
    public List<CityDTOResp> getAll() {
        var cityDTOResps = cityService.getAll();

        return cityDTOResps;
    }
    public long getCount() {
        var count = cityService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        cityService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(CityDTOResp dtoResp) {
        cityService.delete(dtoResp);

        return true;
    }
    public boolean put(CityDTOResp dtoResp) {
        cityService.put(dtoResp);

        return true;
    }
}
