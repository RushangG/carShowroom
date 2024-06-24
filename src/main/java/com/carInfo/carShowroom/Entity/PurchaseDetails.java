package com.carInfo.carShowroom.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Purchase_Details")
public class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int purchaseId;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "amount")
    private BigDecimal amount;

//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private CarDetails car;
    @Column(name = "car_name")
    private String carName;

    public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	@ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerDetails customer;

    @ManyToOne
    @JoinColumn(name = "salesperson_id")
    private Salesperson salesperson;

    // Constructors
    public PurchaseDetails() {
    }

    // Getters and setters
    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

   
    public CustomerDetails getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDetails customer) {
        this.customer = customer;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }
}