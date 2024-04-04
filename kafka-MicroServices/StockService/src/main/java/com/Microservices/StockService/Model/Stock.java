package com.Microservices.StockService.Model;

import jakarta.persistence.*;

@Entity
@Table(name="stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id_product;
    @Column(name = "unit_price")
    private double unit_price;
    @Column(name = "quantity")
    private int quantity;

    public Stock() {}

    public Stock(Long id_product, double unit_price, int quantity) {
        this.id_product = id_product;
        this.unit_price = unit_price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getProductId() {
        return id_product;
    }

    public void setProductId(Long id_product) {
        this.id_product = id_product;
    }

    public double getUnitPrice() {
        return unit_price;
    }

    public void setUnitPrice(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id_product=" + id_product +
                ", unitary price=" + unit_price +
                ", stock quantity=" + quantity +
                '}';
    }
}