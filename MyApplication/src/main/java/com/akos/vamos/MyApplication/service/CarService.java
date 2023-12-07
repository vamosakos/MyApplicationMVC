package com.akos.vamos.MyApplication.service;

import com.akos.vamos.MyApplication.entity.Car;

import java.util.List;

public interface CarService {
    Car getCarById(int id);
    Car saveCar(Car car);
    List<Car> getAllCars();
}
