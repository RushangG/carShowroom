package com.carInfo.carShowroom.Dao;

import java.util.List;

import com.carInfo.carShowroom.Entity.CarDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public class CarDetailsDAOImpl implements CarDetailsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public CarDetails findById(int id) {
        return entityManager.find(CarDetails.class, id);
    }

    @Override
    public List<CarDetails> findAll() {
        return entityManager.createQuery("SELECT cd FROM CarDetails cd", CarDetails.class)
                            .getResultList();
    }

    @Override
    public void save(CarDetails carDetails) {
        entityManager.persist(carDetails);
    }

    @Override
    public void update(CarDetails carDetails) {
        entityManager.merge(carDetails);
    }

    @Override
    public void delete(CarDetails carDetails) {
        entityManager.remove(entityManager.contains(carDetails) ? carDetails : entityManager.merge(carDetails));
    }
}
