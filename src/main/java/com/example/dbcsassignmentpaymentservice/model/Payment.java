package com.example.dbcsassignmentpaymentservice.model;

import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentMethod;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentRouting;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentStatus;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    PaymentStatus paymentStatus;
    PaymentRouting paymentRouting;
    PaymentMethod paymentMethod;

    Long OrderId;

    public Payment(Long id, double amount, PaymentStatus paymentStatus, PaymentRouting paymentRouting, PaymentMethod paymentMethod, Long orderId)
    throws IllegalArgumentException {
        this.id = id;
        this.amount = amount;

        this.paymentStatus = paymentStatus;
        if(paymentRouting.isAvailable())
            this.paymentRouting = paymentRouting;
        else
            throw new IllegalArgumentException("Payment routing is not available");

        if (paymentMethod.isAvailable(this.paymentRouting))
            this.paymentMethod = paymentMethod;
        else
            throw new IllegalArgumentException("Payment method is not available");
        OrderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public PaymentRouting getPaymentRouting() {
        return paymentRouting;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setPaymentRouting(PaymentRouting paymentRouting)
    throws IllegalArgumentException {
        if(paymentRouting.isAvailable())
            this.paymentRouting = paymentRouting;
        else
            throw new IllegalArgumentException("Payment routing is not available");
    }

    public void setPaymentMethod(PaymentMethod paymentMethod)
    throws IllegalArgumentException {
        if (paymentMethod.isAvailable(this.paymentRouting))
            this.paymentMethod = paymentMethod;
        else
            throw new IllegalArgumentException("Payment method is not available");
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }
}
