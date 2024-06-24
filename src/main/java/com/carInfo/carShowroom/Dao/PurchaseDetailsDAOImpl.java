package com.carInfo.carShowroom.Dao;


import com.carInfo.carShowroom.Entity.PurchaseDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PurchaseDetailsDAOImpl implements PurchaseDetailsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PurchaseDetails findById(int id) {
        return entityManager.find(PurchaseDetails.class, id);
    }

    @Override
    public List<PurchaseDetails> findAll() {
        return entityManager.createQuery("SELECT pd FROM PurchaseDetails pd", PurchaseDetails.class)
                            .getResultList();
    }

    @Override
    @Transactional
    public void save(PurchaseDetails purchaseDetails) {
        entityManager.persist(purchaseDetails);
    }

    @Override
    @Transactional
    public void update(PurchaseDetails purchaseDetails) {
        entityManager.merge(purchaseDetails);
    }

    @Override
    @Transactional
    public void delete(PurchaseDetails purchaseDetails) {
        entityManager.remove(entityManager.contains(purchaseDetails) ? purchaseDetails : entityManager.merge(purchaseDetails));
    }
}