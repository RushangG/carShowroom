package com.carInfo.carShowroom.Controller;

import com.carInfo.carShowroom.Entity.PurchaseDetails;
import com.carInfo.carShowroom.Service.PurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase-details")
public class PurchaseDetailsController {

    private final PurchaseDetailsService purchaseDetailsService;

    @Autowired
    public PurchaseDetailsController(PurchaseDetailsService purchaseDetailsService) {
        this.purchaseDetailsService = purchaseDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseDetails> getPurchaseDetailsById(@PathVariable int id) {
        PurchaseDetails purchaseDetails = purchaseDetailsService.findPurchaseDetailsById(id);
        if (purchaseDetails != null) {
            return ResponseEntity.ok(purchaseDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDetails>> getAllPurchaseDetails() {
        List<PurchaseDetails> purchaseDetailsList = purchaseDetailsService.findAllPurchaseDetails();
        return ResponseEntity.ok(purchaseDetailsList);
    }

    @PostMapping
    public ResponseEntity<Void> addPurchaseDetails(@RequestBody PurchaseDetails purchaseDetails) {
        purchaseDetailsService.savePurchaseDetails(purchaseDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePurchaseDetails(@PathVariable int id, @RequestBody PurchaseDetails purchaseDetails) {
        purchaseDetails.setPurchaseId(id);
        purchaseDetailsService.updatePurchaseDetails(purchaseDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseDetails(@PathVariable int id) {
        PurchaseDetails purchaseDetails = purchaseDetailsService.findPurchaseDetailsById(id);
        if (purchaseDetails != null) {
            purchaseDetailsService.deletePurchaseDetails(purchaseDetails);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
