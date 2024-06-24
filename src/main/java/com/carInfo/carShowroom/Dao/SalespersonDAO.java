package com.carInfo.carShowroom.Dao;

import java.util.List;

import com.carInfo.carShowroom.Entity.Salesperson;

public interface SalespersonDAO {
    Salesperson findById(int id);
    List<Salesperson> findAll();
    void save(Salesperson salesperson);
    void update(Salesperson salesperson);
    void delete(Salesperson salesperson);
}
