package com.carInfo.carShowroom.Service;

import com.carInfo.carShowroom.Dao.SalespersonDAO;
import com.carInfo.carShowroom.Entity.Salesperson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalespersonServiceImpl implements SalespersonService {

    private final SalespersonDAO salespersonDAO;

    @Autowired
    public SalespersonServiceImpl(SalespersonDAO salespersonDAO) {
        this.salespersonDAO = salespersonDAO;
    }

    @Override
    public Salesperson findSalespersonById(int id) {
        return salespersonDAO.findById(id);
    }

    @Override
    public List<Salesperson> findAllSalespersons() {
        return salespersonDAO.findAll();
    }

    @Override
    public void saveSalesperson(Salesperson salesperson) {
        salespersonDAO.save(salesperson);
    }

    @Override
    public void updateSalesperson(Salesperson salesperson) {
        salespersonDAO.update(salesperson);
    }

    @Override
    public void deleteSalesperson(Salesperson salesperson) {
        salespersonDAO.delete(salesperson);
    }
}

