package com.example.dbcsassignmentpaymentservice.model;

import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentMethod;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentRouting;
import com.example.dbcsassignmentpaymentservice.model.paymentdata.PaymentStatus;
import com.example.dbcsassignmentpaymentservice.services.PaymentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Transient
    @Autowired
    PaymentService service;

    @HandleAfterSave
    public void handleAfterSave() throws Exception {
        service.savePayment(new Payment(Math.random() * 1000, PaymentStatus.PENDING, PaymentRouting.EN_DET , PaymentMethod.CARD, this.getId()));
    }
}
