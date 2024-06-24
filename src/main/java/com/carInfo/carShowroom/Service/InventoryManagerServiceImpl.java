package com.carInfo.carShowroom.Service;


import com.carInfo.carShowroom.Entity.InventoryManager;
import com.carInfo.carShowroom.Dao.InventoryManagerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryManagerServiceImpl implements InventoryManagerService {

    @Autowired
    private InventoryManagerDAO inventoryManagerDAO;

    @Override
    @Transactional(readOnly = true)
    public InventoryManager findById(int id) {
        return inventoryManagerDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventoryManager> findAll() {
        return inventoryManagerDAO.findAll();
    }

    @Override
    @Transactional
    public void save(InventoryManager manager) {
        inventoryManagerDAO.save(manager);
    }

    @Override
    @Transactional
    public void update(InventoryManager manager) {
        inventoryManagerDAO.update(manager);
    }

    @Override
    @Transactional
    public void delete(InventoryManager manager) {
        inventoryManagerDAO.delete(manager);
    }
}

