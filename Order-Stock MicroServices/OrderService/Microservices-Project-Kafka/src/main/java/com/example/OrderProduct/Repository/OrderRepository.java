package com.example.OrderProduct.Repository;

import com.example.OrderProduct.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository <Order, String> {
}
