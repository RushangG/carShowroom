package com.carInfo.carShowroom.Dao;



import com.carInfo.carShowroom.Entity.Inventory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class InventoryDAOImpl implements InventoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Inventory findById(int id) {
        return entityManager.find(Inventory.class, id);
    }

    @Override
    public List<Inventory> findAll() {
        return entityManager.createQuery("SELECT i FROM Inventory i", Inventory.class)
                            .getResultList();
    }

    @Override
    @Transactional
    public void save(Inventory inventory) {
        entityManager.persist(inventory);
    }

    @Override
    @Transactional
    public void update(Inventory inventory) {
        entityManager.merge(inventory);
    }

    @Override
    @Transactional
    public void delete(Inventory inventory) {
        entityManager.remove(entityManager.contains(inventory) ? inventory : entityManager.merge(inventory));
    }
}