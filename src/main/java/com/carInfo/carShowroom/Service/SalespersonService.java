package com.carInfo.carShowroom.Service;

import com.carInfo.carShowroom.Entity.Salesperson;

import java.util.List;

public interface SalespersonService {
    Salesperson findSalespersonById(int id);
    List<Salesperson> findAllSalespersons();
    void saveSalesperson(Salesperson salesperson);
    void updateSalesperson(Salesperson salesperson);
    void deleteSalesperson(Salesperson salesperson);
}

