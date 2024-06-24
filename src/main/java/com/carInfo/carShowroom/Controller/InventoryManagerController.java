package com.carInfo.carShowroom.Controller;

import com.carInfo.carShowroom.Entity.InventoryManager;
import com.carInfo.carShowroom.Service.InventoryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory-managers")
public class InventoryManagerController {

    private final InventoryManagerService inventoryManagerService;

    @Autowired
    public InventoryManagerController(InventoryManagerService inventoryManagerService) {
        this.inventoryManagerService = inventoryManagerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryManager> getInventoryManagerById(@PathVariable int id) {
        InventoryManager manager = inventoryManagerService.findById(id);
        if (manager != null) {
            return ResponseEntity.ok(manager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<InventoryManager>> getAllInventoryManagers() {
        List<InventoryManager> managers = inventoryManagerService.findAll();
        return ResponseEntity.ok(managers);
    }

    @PostMapping
    public ResponseEntity<Void> addInventoryManager(@RequestBody InventoryManager manager) {
        inventoryManagerService.save(manager);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInventoryManager(@PathVariable int id, @RequestBody InventoryManager manager) {
        manager.setManagerId(id);
        inventoryManagerService.update(manager);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryManager(@PathVariable int id) {
        InventoryManager manager = inventoryManagerService.findById(id);
        if (manager != null) {
            inventoryManagerService.delete(manager);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

