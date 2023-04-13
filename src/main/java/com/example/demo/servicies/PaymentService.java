package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webserviceies.rest.DTOs.requests.PaymentDTOReq;
import com.example.demo.webserviceies.rest.DTOs.resources.PaymentDTOResp;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;
import java.time.Instant;

public class PaymentService extends BaseService<Payment, PaymentDTOResp, PaymentRepo>{
    private CustomerRepo customerRepo;
    private StaffRepo staffRepo;
    private RentalRepo rentalRepo;
    private PaymentRepo paymentRepo;
    private ModelMapper modelMapper;
    public PaymentService(){
        super(new PaymentRepo(), PaymentDTOResp.class);
        this.customerRepo = new CustomerRepo();
        this.staffRepo = new StaffRepo();
        this.rentalRepo = new RentalRepo();
        this.paymentRepo = new PaymentRepo();
        this.modelMapper = new ModelMapper();
    }

    public Payment create(PaymentDTOReq paymentDTOReq) throws PersistenceException {
        //Fetch film and store from db
        Staff staff = staffRepo.getByName("firstName", paymentDTOReq.getStaffFirstName());
        Rental rental = rentalRepo.getById(paymentDTOReq.getRentalId());
        Customer customer = customerRepo.getByName("firstName", paymentDTOReq.getCustomerFirstName());

        //Create payment
        Payment payment = new Payment();
        payment.setPaymentDate(Instant.now());
        payment.setCustomer(customer);
        payment.setAmount(paymentDTOReq.getAmount());
        payment.setRental(rental);
        payment.setLastUpdate(Instant.now());
        payment.setStaff(staff);

        //Save this payment
        try {
            paymentRepo.save(payment);
        }catch (PersistenceException persistenceException){
            throw new PersistenceException("Can't save this payment!!");
        }

        return payment;
    }
}