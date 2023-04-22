package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webservices.rest.DTOs.requests.PaymentDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.PaymentDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class PaymentService extends BaseService<Payment, PaymentDTOResp, PaymentRepo, PaymentDTOReq>{
    @Override
    public Payment post(PaymentDTOReq paymentDTOReq) throws PersistenceException {
        //Fetch film and store from db
        Staff staff = UnitOfWork.getInstance().getStaffRepo().find(paymentDTOReq.getStaffId());
        Rental rental = UnitOfWork.getInstance().getRentalRepo().find(paymentDTOReq.getRentalId());
        Customer customer = UnitOfWork.getInstance().getCustomerRepo().find(paymentDTOReq.getCustomerId());

        //Create payment
        Payment payment = new Payment();
        payment.setPaymentDate(Instant.now());
        payment.setCustomer(customer);
        payment.setAmount(paymentDTOReq.getAmount());
        payment.setRental(rental);
        payment.setStaff(staff);

        //Save this payment
        try {
            UnitOfWork.getInstance().getPaymentRepo().save(payment);
        }catch (PersistenceException persistenceException){
            throw new OperationFaildException("Can't save this payment!!");
        }

        return payment;
    }
}