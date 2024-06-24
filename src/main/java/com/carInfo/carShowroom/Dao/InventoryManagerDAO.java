package com.carInfo.carShowroom.Dao;


import com.carInfo.carShowroom.Entity.InventoryManager;

import java.util.List;

public interface InventoryManagerDAO {
    InventoryManager findById(int id);
    List<InventoryManager> findAll();
    void save(InventoryManager manager);
    void update(InventoryManager manager);
    void delete(InventoryManager manager);
}
