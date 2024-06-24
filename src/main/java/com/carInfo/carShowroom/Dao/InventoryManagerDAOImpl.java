package com.carInfo.carShowroom.Dao;



import com.carInfo.carShowroom.Entity.InventoryManager;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class InventoryManagerDAOImpl implements InventoryManagerDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public InventoryManager findById(int id) {
        return entityManager.find(InventoryManager.class, id);
    }

    @Override
    public List<InventoryManager> findAll() {
        return entityManager.createQuery("SELECT im FROM InventoryManager im", InventoryManager.class)
                            .getResultList();
    }

    @Override
    @Transactional
    public void save(InventoryManager manager) {
        entityManager.persist(manager);
    }

    @Override
    @Transactional
    public void update(InventoryManager manager) {
        entityManager.merge(manager);
    }

    @Override
    @Transactional
    public void delete(InventoryManager manager) {
        entityManager.remove(entityManager.contains(manager) ? manager : entityManager.merge(manager));
    }
}
