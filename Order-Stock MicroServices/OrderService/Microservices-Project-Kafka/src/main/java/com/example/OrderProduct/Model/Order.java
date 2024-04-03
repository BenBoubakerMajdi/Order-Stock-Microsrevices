package com.example.OrderProduct.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private String id_order;
    @Column(name = "id_prod")
    private String id_prod;
    @Column(name = "id_client")
    private String id_client;
    @Column(name = "quantity")
    private Integer quantity;

    public Order(String id_order, String id_prod, String id_client, Integer quantity) {
        this.id_order = id_order;
        this.id_prod = id_prod;
        this.id_client = id_client;
        this.quantity = quantity;
    }

    public Order(String id_order) {
        this.id_order = id_order;
    }

    public Order(String id_prod, String id_client, Integer quantity) {
        this.id_prod = id_prod;
        this.id_client = id_client;
        this.quantity = quantity;
    }

    public Order() {
        this.quantity = 0;
    }

    public String getId_order() {
        return id_order;
    }

    public String getId_prod() {
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

    public static Order parse(String orderString) {

        String[] parts = orderString.split(";");

        Order order = new Order();
        order.setId_order(parts[0]);
        order.setId_prod(parts[1]);
        order.setId_client(parts[2]);
        order.setQuantity(Integer.parseInt(parts[3]));


        return order;
    }
    public String getId_client() {
        return id_client;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setId_order(String id_order) {
        this.id_order = id_order;
    }

    public void setId_prod(String id_prod) {
        this.id_prod = id_prod;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
