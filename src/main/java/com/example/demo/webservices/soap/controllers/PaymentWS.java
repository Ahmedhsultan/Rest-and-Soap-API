package com.example.demo.webservices.soap.controllers;

import com.example.demo.repository.entities.Payment;
import com.example.demo.servicies.PaymentService;
import com.example.demo.webservices.rest.DTOs.requests.PaymentDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.PaymentDTOResp;
import com.example.demo.webservices.soap.exception.SoapException;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class PaymentWS {
    private PaymentService paymentService;
    public PaymentWS(){
        this.paymentService = new PaymentService();
    }
    public Payment post(PaymentDTOReq paymentDTOReq) throws SoapException {
        Payment payment = paymentService.post(paymentDTOReq);

        return payment;
    }
    public List<PaymentDTOResp> get(String columnName, String value, Integer pageNumber, Integer count) {
        var paymentDTOResps = paymentService.get(columnName, value, pageNumber, count);

        return paymentDTOResps;
    }
    public List<PaymentDTOResp> getAll() {
        var paymentDTOResps = paymentService.getAll();

        return paymentDTOResps;
    }
    public long getCount() {
        var count = paymentService.getCount();

        return count;
    }
    public boolean delete(String columnName, String value) {
        paymentService.delete(columnName, value);

        return true;
    }
    public boolean deleteByDTO(PaymentDTOResp dtoResp) {
        paymentService.delete(dtoResp);

        return true;
    }
    public boolean put(PaymentDTOResp dtoResp) {
        paymentService.put(dtoResp);

        return true;
    }
}
