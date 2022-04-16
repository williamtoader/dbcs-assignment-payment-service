package com.example.dbcsassignmentpaymentservice.repositories;

import com.example.dbcsassignmentpaymentservice.model.OrderModel;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderModel, Long> {
}
