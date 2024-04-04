package com.Microservices.OrderService.OrderEvent;

public class OrderEvent {
    private Long id_prod;
    private int quantity;

    // Constructors, getters, and setters
    public OrderEvent() {
    }

    public OrderEvent(Long id_prod, int quantity) {
        this.id_prod = id_prod;
        this.quantity = quantity;
    }

    public Long getIdProd() {
        return id_prod;
    }

    public void setIdProd(Long id_prod) {
        this.id_prod = id_prod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "id_prod='" + id_prod + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
