package org.dreamcatcher.service.impl;

import org.dreamcatcher.dao.CarDao;
import org.dreamcatcher.entity.Car;
import org.dreamcatcher.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by drimcatcher on 09.06.2016.
 */
@Service
public class CarsServiceImpl implements CarsService{
    @Autowired
    CarDao carDao;
    public List<Car> getAllCars() {
        return carDao.findAllCars();
    }

    public void setNewCar(String carName, String carType) {
        if(!carName.isEmpty())
        {
            carDao.saveAndFlush(new Car(carName,carType));
        }
    }
}
