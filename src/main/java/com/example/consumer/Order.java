package com.example.consumer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String id;

    // Names match JSON keys
    @Column(name = "product_name")
    private String product_name;

    private int quantity;
    private int price;

    @Column(name = "total_price")
    private int total_price;

    @Column(name = "process_date")
    private LocalDateTime process_date;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getProduct_name() { return product_name; }
    public void setProduct_name(String product_name) { this.product_name = product_name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public int getTotal_price() { return total_price; }
    public void setTotal_price(int total_price) { this.total_price = total_price; }

    public LocalDateTime getProcess_date() { return process_date; }
    public void setProcess_date(LocalDateTime process_date) { this.process_date = process_date; }
}