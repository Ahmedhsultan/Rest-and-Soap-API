package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Inventory;
import com.example.demo.servicies.InventoryService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.InventoryDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.InventoryDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class InventoryWS {
    private InventoryService inventoryService;
    public InventoryWS(){
        this.inventoryService = new InventoryService();
    }
    public Inventory post(InventoryDTOReq inventoryDTOReq) throws SoapException {
        Inventory inventory = inventoryService.post(inventoryDTOReq);

        return inventory;
    }
    public List<InventoryDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var inventoryDTOResps = inventoryService.get(queryPage);

        return inventoryDTOResps;
    }
    public List<InventoryDTOResp> getAll() {
        var inventoryDTOResps = inventoryService.getAll();

        return inventoryDTOResps;
    }
    public long getCount() {
        var count = inventoryService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        inventoryService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(InventoryDTOResp dtoResp) {
        inventoryService.delete(dtoResp);

        return true;
    }
    public boolean put(InventoryDTOResp dtoResp) {
        inventoryService.put(dtoResp);

        return true;
    }
}
