package com.Microservices.OrderService.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id_order;
    @Column(name = "id_prod")
    private Long id_prod;
    @Column(name = "id_client")
    private String id_client;
    @Column(name = "quantity")
    private Integer quantity;

    public Order(Long id_prod, String id_client, Integer quantity) {
        this.id_prod = id_prod;
        this.id_client = id_client;
        this.quantity = quantity;
    }

    public Order() {
        this.quantity = 0;
    }

    public Long getId_order() {
        return id_order;
    }

    public Long getId_prod() {
        return id_prod;
    }

    @Override
    public String toString() {
        return  id_order + ';' +
                 id_prod + ';' +
                 id_client + ';' +
                quantity
                ;
    }
    public String getId_client() {
        return id_client;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
