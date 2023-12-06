package com.akos.vamos.MyApplication;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class RestApi {

    private final CarService carService;
    @Autowired
    public RestApi(CarService carService) {
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
