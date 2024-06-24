package com.carInfo.carShowroom.Service;

import com.carInfo.carShowroom.Entity.CarDetails;

import java.util.List;

public interface CarDetailsService {
    CarDetails findCarById(int id);
    List<CarDetails> findAllCars();
    void saveCar(CarDetails carDetails);
    void updateCar(CarDetails carDetails);
    void deleteCar(CarDetails carDetails);
}
