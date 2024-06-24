package com.carInfo.carShowroom.Controller;

import com.carInfo.carShowroom.Entity.Inventory;
import com.carInfo.carShowroom.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable int id) {
        Inventory inventory = inventoryService.findById(id);
        if (inventory != null) {
            return ResponseEntity.ok(inventory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventories = inventoryService.findAll();
        return ResponseEntity.ok(inventories);
    }

    @PostMapping
    public ResponseEntity<Void> addInventory(@RequestBody Inventory inventory) {
        inventoryService.save(inventory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInventory(@PathVariable int id, @RequestBody Inventory inventory) {
        inventory.setInventoryId(id);
        inventoryService.update(inventory);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable int id) {
        Inventory inventory = inventoryService.findById(id);
        if (inventory != null) {
            inventoryService.delete(inventory);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
