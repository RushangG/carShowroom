package com.carInfo.carShowroom.Dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.carInfo.carShowroom.Entity.Salesperson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SalespersonDAOImpl implements SalespersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Salesperson findById(int id) {
        return entityManager.find(Salesperson.class, id);
    }

    @Override
    public List<Salesperson> findAll() {
        return entityManager.createQuery("SELECT s FROM Salesperson s", Salesperson.class)
                            .getResultList();
    }

    @Override
    @Transactional
    public void save(Salesperson salesperson) {
        entityManager.persist(salesperson);
    }

    @Override
    @Transactional
    public void update(Salesperson salesperson) {
        entityManager.merge(salesperson);
    }

    @Override
    @Transactional
    public void delete(Salesperson salesperson) {
        entityManager.remove(entityManager.contains(salesperson) ? salesperson : entityManager.merge(salesperson));
    }

	
}
