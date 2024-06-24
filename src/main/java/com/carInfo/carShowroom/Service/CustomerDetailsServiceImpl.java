package com.carInfo.carShowroom.Service;


import com.carInfo.carShowroom.Entity.CustomerDetails;
import com.carInfo.carShowroom.Dao.CustomerDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    private CustomerDetailsDAO customerDetailsDAO;

    @Override
    @Transactional(readOnly = true)
    public CustomerDetails findById(int id) {
        return customerDetailsDAO.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDetails> findAll() {
        return customerDetailsDAO.findAll();
    }

    @Override
    @Transactional
    public void save(CustomerDetails customerDetails) {
        customerDetailsDAO.save(customerDetails);
    }

    @Override
    @Transactional
    public void update(CustomerDetails customerDetails) {
        customerDetailsDAO.update(customerDetails);
    }

    @Override
    @Transactional
    public void delete(CustomerDetails customerDetails) {
        customerDetailsDAO.delete(customerDetails);
    }
}

