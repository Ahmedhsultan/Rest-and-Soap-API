package com.example.demo.servicies;

import com.example.demo.repository.UnitOfWork;
import com.example.demo.repository.entities.Customer;
import com.example.demo.repository.entities.Payment;
import com.example.demo.repository.entities.Rental;
import com.example.demo.repository.entities.Staff;
import com.example.demo.repository.repos.PaymentRepo;
import com.example.demo.webservices.rest.DTOs.requests.PaymentDTOReq;
import com.example.demo.webservices.rest.DTOs.resources.PaymentDTOResp;
import com.example.demo.webservices.rest.exception.exceptions.OperationFaildException;
import jakarta.persistence.PersistenceException;

import java.time.Instant;

public class PaymentService extends BaseService<Payment, PaymentDTOResp, PaymentRepo, PaymentDTOReq> {
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
        } catch (PersistenceException persistenceException) {
            throw new OperationFaildException("Can't save this payment!!");
        }

        return payment;
    }
}