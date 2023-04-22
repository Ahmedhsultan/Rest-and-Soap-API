package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Store;
import com.example.demo.servicies.StoreService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.StoreDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StoreDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public class StoreWS {
    private StoreService storeService;

    public StoreWS() {
        this.storeService = new StoreService();
    }

    public Store post(StoreDTOReq storeDTOReq) throws SoapException {
        Store store = storeService.post(storeDTOReq);

        return store;
    }

    public List<StoreDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var storeDTOResps = storeService.get(queryPage);

        return storeDTOResps;
    }

    public List<StoreDTOResp> getAll() {
        var storeDTOResps = storeService.getAll();

        return storeDTOResps;
    }

    public long getCount() {
        var count = storeService.getCount();

        return count;
    }

    public boolean delete(String columnName, String value) {
        storeService.delete(columnName, value);

        return true;
    }

    public boolean deleteByDTO(StoreDTOResp dtoResp) {
        storeService.delete(dtoResp);

        return true;
    }

    public boolean put(StoreDTOResp dtoResp) {
        storeService.put(dtoResp);

        return true;
    }
}
