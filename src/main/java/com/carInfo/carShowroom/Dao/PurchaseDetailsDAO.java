package com.carInfo.carShowroom.Dao;

import com.carInfo.carShowroom.Entity.PurchaseDetails;

import java.util.List;


public interface PurchaseDetailsDAO {
    PurchaseDetails findById(int id);
    List<PurchaseDetails> findAll();
    void save(PurchaseDetails purchaseDetails);
    void update(PurchaseDetails purchaseDetails);
    void delete(PurchaseDetails purchaseDetails);
}