package org.dreamcatcher.service;

import org.dreamcatcher.entity.Car;

import java.util.List;

/**
 * Created by drimcatcher on 09.06.2016.
 */
public interface CarsService {

    List<Car> getAllCars();

    void setNewCar(String carName, String carType);


}
