package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Staff;
import com.example.demo.servicies.StaffService;
import com.example.demo.webservices.rest.DTOs.requests.StaffDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.StaffDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class StaffWS {
    private StaffService staffService;
    public StaffWS(){
        this.staffService = new StaffService();
    }
    public Staff post(StaffDTOReq staffDTOReq) throws SoapException {
        Staff staff = staffService.post(staffDTOReq);

        return staff;
    }
    public List<StaffDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        var staffDTOResps = staffService.get(columnName, value, pageNumber, count);

        return staffDTOResps;
    }
    public List<StaffDTOResp> getAll() {
        var staffDTOResps = staffService.getAll();

        return staffDTOResps;
    }
    public long getCount() {
        var count = staffService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        staffService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(StaffDTOResp dtoResp) {
        staffService.delete(dtoResp);

        return true;
    }
    public boolean put(StaffDTOResp dtoResp) {
        staffService.put(dtoResp);

        return true;
    }
}
