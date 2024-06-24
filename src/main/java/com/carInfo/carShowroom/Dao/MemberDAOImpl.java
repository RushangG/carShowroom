package com.carInfo.carShowroom.Dao;


import com.carInfo.carShowroom.Entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAOImpl implements MemberDAO {

    private final EntityManager entityManager;

    @Autowired
    public MemberDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Member findById(String userId) {
        return entityManager.find(Member.class, userId);
    }

    @Override
    public void update(Member member) {
        entityManager.merge(member);
    }

    @Override
    public void delete(Member member) {
        entityManager.remove(member);
    }

    @Override
    public List<Member> findAll() {
        TypedQuery<Member> query = entityManager.createQuery("SELECT m FROM Member m", Member.class);
        return query.getResultList();
    }
}