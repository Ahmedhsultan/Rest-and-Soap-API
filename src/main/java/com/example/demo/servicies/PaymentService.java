package com.example.demo.servicies;

import com.example.demo.repository.entities.*;
import com.example.demo.repository.repos.*;
import com.example.demo.webserviceies.rest.DTOs.PaymentDTO;
import jakarta.persistence.PersistenceException;
import org.modelmapper.ModelMapper;

import java.time.Instant;

public class PaymentService {
    private CustomerRepo customerRepo;
    private StaffRepo staffRepo;
    private RentalRepo rentalRepo;
    private PaymentRepo paymentRepo;
    private ModelMapper modelMapper;
    public PaymentService(){
        this.customerRepo = new CustomerRepo();
        this.staffRepo = new StaffRepo();
        this.rentalRepo = new RentalRepo();
        this.paymentRepo = new PaymentRepo();
        this.modelMapper = new ModelMapper();
    }

    public Payment create(PaymentDTO paymentDTO) throws PersistenceException {
        //Fetch film and store from db
        Staff staff = staffRepo.getByName("firstName", paymentDTO.getStaffFirstName());
        Rental rental = rentalRepo.getById(paymentDTO.getRentalId());
        Customer customer = customerRepo.getByName("firstName", paymentDTO.getCustomerFirstName());

        //Create payment
        Payment payment = new Payment();
        payment.setPaymentDate(Instant.now());
        payment.setCustomer(customer);
        payment.setAmount(paymentDTO.getAmount());
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