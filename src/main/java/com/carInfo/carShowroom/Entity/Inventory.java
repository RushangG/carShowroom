package com.carInfo.carShowroom.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Inventory")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;
    
    
    @OneToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private CarDetails car;

    @Column(name = "quantity")
    private int quantity;
    
    // Constructors
    public Inventory() {
    }

    public Inventory(CarDetails car, int quantity) {
        this.car = car;
        this.quantity = quantity;
    }
    
    // Getters and setters
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public CarDetails getCar() {
        return car;
    }

    public void setCar(CarDetails car) {
        this.car = car;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}