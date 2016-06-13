package org.dreamcatcher.dao;

import org.dreamcatcher.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by drimcatcher on 07.06.2016.
 */
public interface CarDao extends JpaRepository<Car, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Car c SET c.nowRent= ?2 WHERE c.id = ?1 ")
    void updateNewRentInCar(Integer id, boolean nowRent);

    @Query("SELECT c FROM Car c WHERE c.nowRent=false")
    List<Car> findAllCars();
}
