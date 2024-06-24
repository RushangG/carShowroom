package com.carInfo.carShowroom.Dao;


import com.carInfo.carShowroom.Entity.Role;
import com.carInfo.carShowroom.Entity.RoleId;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private final EntityManager entityManager;

    @Autowired
    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    @Transactional
    public Role findById(RoleId id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    @Transactional
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        entityManager.remove(role);
    }
}
