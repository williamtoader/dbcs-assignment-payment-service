package com.example.dbcsassignmentpaymentservice.services.dev;

import com.example.dbcsassignmentpaymentservice.model.Payment;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentMethod;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentRouting;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentStatus;
import com.example.dbcsassignmentpaymentservice.repositories.PaymentRepository;
import com.example.dbcsassignmentpaymentservice.services.PaymentService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class TestPaymentServiceImpl implements PaymentService {
    PaymentRepository repository;
    @Override
    public Payment savePayment(Payment payment) {
        //save to repo
        payment.setPaymentRouting(PaymentRouting.TEST);
        payment.setPaymentMethod(PaymentMethod.TEST);
        return repository.save(payment);
    }

    @Override
    public Payment getPayment(String id) {
        return null;
    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public PaymentStatus handlePayment(Payment payment) {
        return null;
    }
}
