package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Customer;
import com.example.demo.servicies.CustomerService;
import com.example.demo.util.records.QueryPage;
import com.example.demo.webservices.rest.DTOs.requests.CustomerDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.CustomerDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;

import java.util.List;

public class CustomerWS {
    private CustomerService customerService;

    public CustomerWS() {
        this.customerService = new CustomerService();
    }

    public Customer post(CustomerDTOReq customerDTOReq) throws SoapException {
        Customer customer = customerService.post(customerDTOReq);

        return customer;
    }

    public List<CustomerDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        QueryPage queryPage = new QueryPage(columnName, value, pageNumber, count);
        var customerDTOResps = customerService.get(queryPage);

        return customerDTOResps;
    }

    public List<CustomerDTOResp> getAll() {
        var customerDTOResps = customerService.getAll();

        return customerDTOResps;
    }

    public long getCount() {
        var count = customerService.getCount();

        return count;
    }

    public boolean delete(String columnName, String value) {
        customerService.delete(columnName, value);

        return true;
    }

    public boolean deleteByDTO(CustomerDTOResp dtoResp) {
        customerService.delete(dtoResp);

        return true;
    }

    public boolean put(CustomerDTOResp dtoResp) {
        customerService.put(dtoResp);

        return true;
    }
}
