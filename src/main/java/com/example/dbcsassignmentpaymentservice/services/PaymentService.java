package com.example.dbcsassignmentpaymentservice.services;

import com.example.dbcsassignmentpaymentservice.model.Payment;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentStatus;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public Payment savePayment(Payment payment) throws Exception;
    public Payment getPayment(String id);
    public void deletePayment(String id);
    public PaymentStatus handlePayment(Payment payment) throws Exception;
}
