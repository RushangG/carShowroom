package com.carInfo.carShowroom.Controller;

import com.carInfo.carShowroom.Entity.CarDetails;
import com.carInfo.carShowroom.Service.CarDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarDetailsController {

    private final CarDetailsService carDetailsService;

    @Autowired
    public CarDetailsController(CarDetailsService carDetailsService) {
        this.carDetailsService = carDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDetails> getCarById(@PathVariable int id) {
        CarDetails carDetails = carDetailsService.findCarById(id);
        if (carDetails != null) {
            return ResponseEntity.ok(carDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<CarDetails>> getAllCars() {
        List<CarDetails> cars = carDetailsService.findAllCars();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<Void> addCar(@RequestBody CarDetails carDetails) {
        carDetailsService.saveCar(carDetails);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable int id, @RequestBody CarDetails carDetails) {
        carDetails.setCarId(id);
        carDetailsService.updateCar(carDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        CarDetails carDetails = carDetailsService.findCarById(id);
        if (carDetails != null) {
            carDetailsService.deleteCar(carDetails);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
