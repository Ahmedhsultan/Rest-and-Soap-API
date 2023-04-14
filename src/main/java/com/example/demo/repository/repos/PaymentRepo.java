package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Payment;
import jakarta.persistence.EntityManager;

public class PaymentRepo extends BaseRepo<Payment, Integer>{

    public PaymentRepo() {
        super(Payment.class);
    }
}
