package com.carInfo.carShowroom.Dao;



import com.carInfo.carShowroom.Entity.Role;
import com.carInfo.carShowroom.Entity.RoleId;
import java.util.List;

public interface RoleDAO {
    void save(Role role);
    Role findById(RoleId id);
    List<Role> findAll();
    void update(Role role);
    void delete(Role role);
}
