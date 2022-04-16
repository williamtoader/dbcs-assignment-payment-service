package com.example.dbcsassignmentpaymentservice.model.paymentdata;

public enum PaymentMethod {
    CASH,
    CARD,
    BANK_TRANSFER,
    TEST;

    public Boolean isAvailable(PaymentRouting routing) {
        switch (routing) {
            case TEST:
                return this == TEST;
            case EN_DET:
                return this == CASH || this == CARD;
            case EN_GROSS:
                return this == BANK_TRANSFER;
        }
        return false;
    }
}
