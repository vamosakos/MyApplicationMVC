package com.akos.vamos.MyApplication.repository;

import com.akos.vamos.MyApplication.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
}
