package com.carInfo.carShowroom.Dao;



import com.carInfo.carShowroom.Entity.CustomerDetails;

import java.util.List;

public interface CustomerDetailsDAO {
    CustomerDetails findById(int id);
    List<CustomerDetails> findAll();
    void save(CustomerDetails customerDetails);
    void update(CustomerDetails customerDetails);
    void delete(CustomerDetails customerDetails);
}
