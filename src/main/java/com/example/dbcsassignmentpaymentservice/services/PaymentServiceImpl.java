package com.example.dbcsassignmentpaymentservice.services;

import com.example.dbcsassignmentpaymentservice.model.Payment;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentMethod;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentRouting;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentStatus;
import org.springframework.context.annotation.Profile;

@Profile("!dev")
public class PaymentServiceImpl implements PaymentService {
    private static final double TRANSFER_TO_EN_GROSS_THRESHOLD_AMOUNT = 3000;
    @Override
    public Payment savePayment(Payment payment) throws Exception{
        if (payment.getAmount() >= TRANSFER_TO_EN_GROSS_THRESHOLD_AMOUNT) {
            payment.setPaymentRouting(PaymentRouting.EN_GROSS);
            payment.setPaymentMethod(PaymentMethod.BANK_TRANSFER);
            if(!payment.getPaymentRouting().isAvailable()) {
                //TODO: should throw exeption here
                return null;
            }
        }
        switch (payment.getPaymentStatus()) {

            case FAILED:
                break;
            case PENDING:
                //handle payment and wait for status change
                //set completed on validation
                handlePayment(payment);
                payment.setPaymentStatus(PaymentStatus.COMPLETED);
                break;
            case COMPLETED:
                //payment cannot have initial status of completed
                break;
        }
        return null;
    }

    @Override
    public Payment getPayment(String id) {
        return null;
    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public PaymentStatus handlePayment(Payment payment) throws Exception {
        //We suppose that there is an actual payment validation service used here and not just a random number generator
        //VERY bad idea, lmao :), coding while drunk is fun
        if(Math.floor(Math.random() * 10) % 2 == 0)
            throw new Exception("Failed to auhenticate payment details");
        return null;
    }
}
