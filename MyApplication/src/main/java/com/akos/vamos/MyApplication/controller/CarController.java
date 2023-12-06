package com.akos.vamos.MyApplication.controller;

import com.akos.vamos.MyApplication.entity.Car;
import com.akos.vamos.MyApplication.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        try {
            Car car = carService.getCarById(id);
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
        catch (EntityNotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Car> postCar(@RequestBody Car carToSave) {
        try {
            Car savedCar = carService.saveCar(carToSave);
            return new ResponseEntity<>(savedCar, HttpStatus.OK);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
