package com.carInfo.carShowroom.Service;

import com.carInfo.carShowroom.Dao.CarDetailsDAO;
import com.carInfo.carShowroom.Entity.CarDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDetailsServiceImpl implements CarDetailsService {

    private final CarDetailsDAO carDetailsDAO;

    @Autowired
    public CarDetailsServiceImpl(CarDetailsDAO carDetailsDAO) {
        this.carDetailsDAO = carDetailsDAO;
    }

    @Override
    public CarDetails findCarById(int id) {
        return carDetailsDAO.findById(id);
    }

    @Override
    public List<CarDetails> findAllCars() {
        return carDetailsDAO.findAll();
    }

    @Override
    public void saveCar(CarDetails carDetails) {
        carDetailsDAO.save(carDetails);
    }

    @Override
    public void updateCar(CarDetails carDetails) {
        carDetailsDAO.update(carDetails);
    }

    @Override
    public void deleteCar(CarDetails carDetails) {
        carDetailsDAO.delete(carDetails);
    }
}

