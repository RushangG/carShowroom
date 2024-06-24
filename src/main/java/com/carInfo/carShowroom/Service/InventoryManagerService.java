package com.carInfo.carShowroom.Service;


import com.carInfo.carShowroom.Entity.InventoryManager;

import java.util.List;

public interface InventoryManagerService {
    InventoryManager findById(int id);
    List<InventoryManager> findAll();
    void save(InventoryManager manager);
    void update(InventoryManager manager);
    void delete(InventoryManager manager);
}

