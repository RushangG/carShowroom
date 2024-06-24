package com.carInfo.carShowroom.Service;

import com.carInfo.carShowroom.Dao.PurchaseDetailsDAO;
import com.carInfo.carShowroom.Entity.PurchaseDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {

    private final PurchaseDetailsDAO purchaseDetailsDAO;

    @Autowired
    public PurchaseDetailsServiceImpl(PurchaseDetailsDAO purchaseDetailsDAO) {
        this.purchaseDetailsDAO = purchaseDetailsDAO;
    }

    @Override
    public PurchaseDetails findPurchaseDetailsById(int id) {
        return purchaseDetailsDAO.findById(id);
    }

    @Override
    public List<PurchaseDetails> findAllPurchaseDetails() {
        return purchaseDetailsDAO.findAll();
    }

    @Override
    public void savePurchaseDetails(PurchaseDetails purchaseDetails) {
        purchaseDetailsDAO.save(purchaseDetails);
    }

    @Override
    public void updatePurchaseDetails(PurchaseDetails purchaseDetails) {
        purchaseDetailsDAO.update(purchaseDetails);
    }

    @Override
    public void deletePurchaseDetails(PurchaseDetails purchaseDetails) {
        purchaseDetailsDAO.delete(purchaseDetails);
    }
}

