package com.carInfo.carShowroom.Controller;

import com.carInfo.carShowroom.Entity.Salesperson;
import com.carInfo.carShowroom.Service.SalespersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salespersons")
public class SalespersonController {

    private final SalespersonService salespersonService;

    @Autowired
    public SalespersonController(SalespersonService salespersonService) {
        this.salespersonService = salespersonService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salesperson> getSalespersonById(@PathVariable int id) {
        Salesperson salesperson = salespersonService.findSalespersonById(id);
        if (salesperson != null) {
            return ResponseEntity.ok(salesperson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Salesperson>> getAllSalespersons() {
        List<Salesperson> salespersonList = salespersonService.findAllSalespersons();
        return ResponseEntity.ok(salespersonList);
    }

    @PostMapping
    public ResponseEntity<Void> addSalesperson(@RequestBody Salesperson salesperson) {
        salespersonService.saveSalesperson(salesperson);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSalesperson(@PathVariable int id, @RequestBody Salesperson salesperson) {
        salesperson.setSalespersonId(id);
        salespersonService.updateSalesperson(salesperson);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesperson(@PathVariable int id) {
        Salesperson salesperson = salespersonService.findSalespersonById(id);
        if (salesperson != null) {
            salespersonService.deleteSalesperson(salesperson);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
