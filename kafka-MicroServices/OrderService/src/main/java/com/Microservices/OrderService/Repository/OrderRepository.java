package com.Microservices.OrderService.Repository;

import com.Microservices.OrderService.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order, String> {
}
