package com.carInfo.carShowroom.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "pw")
    private String password;

    @Column(name = "active")
    private boolean active;

    // Constructors

    public Member() {
    }

    public Member(String userId, String password, boolean active) {
        this.userId = userId;
        this.password = password;
        this.active = active;
    }

    // Getters and Setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

