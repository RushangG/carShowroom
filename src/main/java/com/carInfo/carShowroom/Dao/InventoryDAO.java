package com.carInfo.carShowroom.Dao;


import com.carInfo.carShowroom.Entity.Inventory;

import java.util.List;


public interface InventoryDAO {
    Inventory findById(int id);
    List<Inventory> findAll();
    void save(Inventory inventory);
    void update(Inventory inventory);
    void delete(Inventory inventory);
}

