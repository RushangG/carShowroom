package com.carInfo.carShowroom.Entity;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_Details")
public class CarDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;
    
    @Column(name = "model")
    private String model;
    
    @Column(name = "manufacturer")
    private String manufacturer;
    
    @Column(name = "year")
    private int year;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "price")
    private BigDecimal price;

    
//    @OneToMany(mappedBy = "car", cascade = {CascadeType.ALL})
//    private List<Inventory> inventories;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private Inventory inventory;
    
   
    
    // Getters and setters
    // Constructors
    public CarDetails() {
    }

    public CarDetails(String model, String manufacturer, int year, String color, BigDecimal price) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.color = color;
        this.price = price;
    }
    
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}