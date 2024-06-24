package com.carInfo.carShowroom.Service;





import com.carInfo.carShowroom.Dao.RoleDAO;
import com.carInfo.carShowroom.Entity.Role;
import com.carInfo.carShowroom.Entity.RoleId;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDAO;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Override
    public Role findById(RoleId id) {
        return roleDAO.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    @Transactional
    public void update(Role role) {
        roleDAO.update(role);
    }

    @Override
    @Transactional
    public void delete(Role role) {
        roleDAO.delete(role);
    }
}

