package com.example.demo.repository.repos;

import com.example.demo.repository.entities.Payment;
import jakarta.persistence.EntityManager;

public class PaymentRepo extends BaseRepo<Payment, Integer, String>{

    public PaymentRepo(EntityManager entityManager) {
        super(entityManager, Payment.class);
    }
}
