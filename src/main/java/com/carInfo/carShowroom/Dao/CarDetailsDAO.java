package com.carInfo.carShowroom.Dao;
import java.util.List;
import com.carInfo.carShowroom.Entity.CarDetails;


public interface CarDetailsDAO {
    CarDetails findById(int id);
    List<CarDetails> findAll();
    void save(CarDetails carDetails);
    void update(CarDetails carDetails);
    void delete(CarDetails carDetails);
}

