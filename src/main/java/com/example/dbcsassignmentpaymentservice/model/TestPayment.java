package com.example.dbcsassignmentpaymentservice.model;

public class TestPayment extends Payment {
    public TestPayment() {
        super();
        this.setPaymentType("Test");
    }

    public TestPayment(Long id, String amount, String date, String status) {
        super(id, "Test", amount, date, status);
    }
}
