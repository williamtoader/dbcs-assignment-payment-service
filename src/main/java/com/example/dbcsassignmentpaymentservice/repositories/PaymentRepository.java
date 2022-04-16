package com.example.dbcsassignmentpaymentservice.repositories;

import com.example.dbcsassignmentpaymentservice.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
