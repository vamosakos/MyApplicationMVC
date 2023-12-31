package com.akos.vamos.MyApplication.service;

import com.akos.vamos.MyApplication.entity.Car;
import com.akos.vamos.MyApplication.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCarById(int id) {
        Optional<Car> foundCar = carRepository.findById(id);
        if (foundCar.isEmpty()) {
            throw new EntityNotFoundException("Car not found with this id: " + id);
        }
        return foundCar.get();
    }
    @Override
    public Car saveCar(Car carToSave) {
        return carRepository.save(carToSave);
    }

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }
}
