package com.carInfo.carShowroom.Dao;


import com.carInfo.carShowroom.Entity.CustomerDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class CustomerDetailsDAOImpl implements CustomerDetailsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CustomerDetails findById(int id) {
        return entityManager.find(CustomerDetails.class, id);
    }

    @Override
    public List<CustomerDetails> findAll() {
        return entityManager.createQuery("SELECT cd FROM CustomerDetails cd", CustomerDetails.class)
                            .getResultList();
    }

    @Override
    @Transactional
    public void save(CustomerDetails customerDetails) {
        entityManager.persist(customerDetails);
    }

    @Override
    @Transactional
    public void update(CustomerDetails customerDetails) {
        entityManager.merge(customerDetails);
    }

    @Override
    @Transactional
    public void delete(CustomerDetails customerDetails) {
        entityManager.remove(entityManager.contains(customerDetails) ? customerDetails : entityManager.merge(customerDetails));
    }
}

