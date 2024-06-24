package com.carInfo.carShowroom.Service;


import com.carInfo.carShowroom.Entity.Inventory;
import com.carInfo.carShowroom.Dao.InventoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDAO inventoryDAO;

    @Override
    @Transactional(readOnly = true)
    public Inventory findById(int id) {
        return inventoryDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inventory> findAll() {
        return inventoryDAO.findAll();
    }

    @Override
    @Transactional
    public void save(Inventory inventory) {
        inventoryDAO.save(inventory);
    }

    @Override
    @Transactional
    public void update(Inventory inventory) {
        inventoryDAO.update(inventory);
    }

    @Override
    @Transactional
    public void delete(Inventory inventory) {
        inventoryDAO.delete(inventory);
    }
}

