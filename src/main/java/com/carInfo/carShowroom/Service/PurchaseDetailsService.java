package com.carInfo.carShowroom.Service;

import com.carInfo.carShowroom.Entity.PurchaseDetails;

import java.util.List;

public interface PurchaseDetailsService {
    PurchaseDetails findPurchaseDetailsById(int id);
    List<PurchaseDetails> findAllPurchaseDetails();
    void savePurchaseDetails(PurchaseDetails purchaseDetails);
    void updatePurchaseDetails(PurchaseDetails purchaseDetails);
    void deletePurchaseDetails(PurchaseDetails purchaseDetails);
}

