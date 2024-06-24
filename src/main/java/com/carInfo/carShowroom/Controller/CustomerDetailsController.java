package com.carInfo.carShowroom.Controller;

import com.carInfo.carShowroom.Entity.CustomerDetails;
import com.carInfo.carShowroom.Service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;

    @Autowired
    public CustomerDetailsController(CustomerDetailsService customerDetailsService) {
        this.customerDetailsService = customerDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetails> getCustomerById(@PathVariable int id) {
        CustomerDetails customerDetails = customerDetailsService.findById(id);
        if (customerDetails != null) {
            return ResponseEntity.ok(customerDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getAllCustomers() {
        List<CustomerDetails> customers = customerDetailsService.findAll();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerDetails customerDetails) {
        customerDetailsService.save(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable int id, @RequestBody CustomerDetails customerDetails) {
        customerDetails.setCustomerId(id);
        customerDetailsService.update(customerDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        CustomerDetails customerDetails = customerDetailsService.findById(id);
        if (customerDetails != null) {
            customerDetailsService.delete(customerDetails);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
