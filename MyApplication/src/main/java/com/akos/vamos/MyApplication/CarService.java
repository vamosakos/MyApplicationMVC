package com.akos.vamos.MyApplication;

import java.util.List;
import java.util.Optional;

public interface CarService {


    Car getCarById(int id);
    Car saveCar(Car car);
}
