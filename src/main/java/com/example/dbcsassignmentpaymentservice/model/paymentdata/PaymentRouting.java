package com.example.dbcsassignmentpaymentservice.model.paymentdata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

public enum PaymentRouting {
    EN_DET,
    EN_GROSS,
    TEST;

    @Value("${spring.profiles.active:}")
    private String activeProfile;

    public Boolean isAvailable() {
        return this != TEST || activeProfile.equals("dev");
    }
}
