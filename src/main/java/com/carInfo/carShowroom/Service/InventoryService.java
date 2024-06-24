package com.carInfo.carShowroom.Service;

import com.carInfo.carShowroom.Entity.Inventory;

import java.util.List;

public interface InventoryService {
    Inventory findById(int id);
    List<Inventory> findAll();
    void save(Inventory inventory);
    void update(Inventory inventory);
    void delete(Inventory inventory);
}

