package com.example.dbcsassignmentpaymentservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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

    @HandleAfterSave
    public void handleAfterSave() {

    }
}
